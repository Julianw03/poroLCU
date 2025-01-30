package com.julianw03.poroLCU.connection.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.InetAddress;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

public class RiotSSLContext {
    private static final String PRINCIPAL_CLIENT = "CN=rclient";

    private RiotSSLContext() {}

    public static SSLContext create() throws NoSuchAlgorithmException {
        return init(SSLContext.getInstance("TLS"));
    }

    private static SSLContext init(SSLContext sslContext) {
        try
        {
            sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    if (chain != null && chain.length > 0) {
                        String clientHost = chain[0].getSubjectX500Principal().getName();
                        if (isLoopbackAddress(clientHost) || PRINCIPAL_CLIENT.equals(clientHost)) {
                            return;
                        }
                    }
                    throw new CertificateException("Untrusted client certificate");
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    if (chain != null && chain.length > 0) {
                        String serverHost = chain[0].getSubjectX500Principal().getName();
                        if (isLoopbackAddress(serverHost) || PRINCIPAL_CLIENT.equals(serverHost)) {
                            return;
                        }
                    }
                    throw new CertificateException("Untrusted server certificate");

                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            }}, new SecureRandom());
        } catch (KeyManagementException e)
        {
            throw new RuntimeException("Failed to initialize an SSLContext.", e);
        }
        return sslContext;
    }

    private static boolean isLoopbackAddress(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            return address.isLoopbackAddress();
        } catch (Exception e) {
            return false;
        }
    }
}
