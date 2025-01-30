package com.julianw03.poroLCU.model.riotclient;

import com.julianw03.poroLCU.connection.http.LCUApiResponse;
import com.julianw03.poroLCU.connection.http.LCUHttpConnector;
import com.julianw03.poroLCU.model.PluginInterface;

import java.util.function.Function;

public interface Riotclient extends PluginInterface {
    /**
     * Deletes the current runtime affinity of the application
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> deleteAffinity();

    /**
     * Get the current runtime affinity of the application.
     */
    Function<LCUHttpConnector, LCUApiResponse<Affinity>> getAffinity();

    /**
     * Sets the current runtime affinity of the application.
     */
    Function<LCUHttpConnector, LCUApiResponse<Void>> postAffinity(Affinity affinity);

    /**
     * Application name without file extension
     */
    Function<LCUHttpConnector, LCUApiResponse<String>> getAppName();

    /**
     * Get the TCP port number that the remoting server is listening on.
     */
    Function<LCUHttpConnector, LCUApiResponse<Integer>> getAppPort();

    /**
     * Return the auth token used by the remoting server
     */
    Function<LCUHttpConnector, LCUApiResponse<String>> getAuthToken();

    Function<LCUHttpConnector, LCUApiResponse<String>> getClipboard();

    Function<LCUHttpConnector, LCUApiResponse<Boolean>> postClipboard(String clipboard);

    Function<LCUHttpConnector, LCUApiResponse<String[]>> getCommandLineArgs();

    Function<LCUHttpConnector, LCUApiResponse<Void>> killAndRestartUx();

    Function<LCUHttpConnector, LCUApiResponse<Void>> killUx();

    Function<LCUHttpConnector, LCUApiResponse<Void>> launchUx();

    Function<LCUHttpConnector, LCUApiResponse<String>> getMachineId();

    Function<LCUHttpConnector, LCUApiResponse<Void>> openUrlInBrowser(String url);

    Function<LCUHttpConnector, LCUApiResponse<RegionLocale>> getRegionLocale();

    Function<LCUHttpConnector, LCUApiResponse<Void>> showSwagger();

    Function<LCUHttpConnector, LCUApiResponse<Void>> hideSplashScreen();

    Function<LCUHttpConnector, LCUApiResponse<Void>> showSplashScreen();

    Function<LCUHttpConnector, LCUApiResponse<SystemInfo>> getBasicInfo();

    Function<LCUHttpConnector, LCUApiResponse<Void>> unloadUxProcess();

    Function<LCUHttpConnector, LCUApiResponse<Void>> uxAllowForeground();

    Function<LCUHttpConnector, LCUApiResponse<Integer>> getUxCrashCount();

    Function<LCUHttpConnector, LCUApiResponse<Void>> uxFlash();

    Function<LCUHttpConnector, LCUApiResponse<Void>> putUxLoadComplete();

    Function<LCUHttpConnector, LCUApiResponse<Void>> uxMinimize();

    Function<LCUHttpConnector, LCUApiResponse<Void>> uxShow();

    Function<LCUHttpConnector, LCUApiResponse<String>> getUxState();

    Function<LCUHttpConnector, LCUApiResponse<Void>> acknowledgeUxState(String state);

    Function<LCUHttpConnector, LCUApiResponse<String>> deleteAuthToken(String token);

    Function<LCUHttpConnector, LCUApiResponse<String>> registerAuthToken(String token);

    Function<LCUHttpConnector, LCUApiResponse<CrashEnvironment>> getCrashEnvironment();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setCrashEnvironment(CrashEnvironment crashEnvironment);

    Function<LCUHttpConnector, LCUApiResponse<Double>> getZoomScale();

    Function<LCUHttpConnector, LCUApiResponse<Void>> setZoomScale(double zoomScale);
}
