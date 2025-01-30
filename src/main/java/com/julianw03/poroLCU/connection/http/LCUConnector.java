package com.julianw03.poroLCU.connection.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.Util.JsonNodeBodyHandler;
import com.julianw03.poroLCU.connection.ssl.RiotSSLContext;
import com.julianw03.poroLCU.process.LeagueClientProcessParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LCUConnector implements LCUHttpConnector {

    private static final Logger log = LoggerFactory.getLogger(LCUConnector.class);

    public static boolean testConnection(LeagueClientProcessParameters parameters) {
        try {
            HttpClient client = HttpClient
                    .newBuilder()
                    .sslContext(RiotSSLContext.create())
                    .build();


            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://127.0.0.1:" + parameters.getAppPort() + "/riotclient/command-line-args"))
                    .setHeader("Authorization", parameters.getAuthHeaderValue())
                    .build();


            HttpResponse<JsonNode> response = client.send(request, new JsonNodeBodyHandler());
            LCUApiResponse<List<String>> apiResponse = new LCUApiResponse<>(response, new TypeReference<>() {
            });
            List<String> commandLineArgs = apiResponse.getResponseBody().getLeft();

            return commandLineArgs != null && !commandLineArgs.isEmpty();
        } catch (Exception e) {
            log.error("Failed to test connection", e);
            return false;
        }
    }

    private final HttpClient                    client;
    private final LeagueClientProcessParameters parameters;

    public LCUConnector(
            LeagueClientProcessParameters parameters
    ) {
        this.parameters = parameters;
        try {
            this.client = HttpClient
                    .newBuilder()
                    .sslContext(RiotSSLContext.create())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create LCUConnector", e);
        }
    }

    @Override
    public <T> HttpResponse<T> sendRequest(HttpMethod method, String relativePath, String body, HttpResponse.BodyHandler<T> handler) {
        CompletableFuture<HttpResponse<T>> future = sendRequestAsync(method, relativePath, body, handler);
        if (future == null) return null;
        try {
            return future.join();
        } catch (Exception e) {
            log.error("Failed to send request", e);
            return null;
        }
    }

    @Override
    public <T> CompletableFuture<HttpResponse<T>> sendRequestAsync(HttpMethod method, String relativePath, String body, HttpResponse.BodyHandler<T> handler) {
        HttpRequest.BodyPublisher bodyPublisher = body == null ? HttpRequest.BodyPublishers.noBody() : HttpRequest.BodyPublishers.ofString(body);
        HttpRequest request = HttpRequest.newBuilder()
                .headers("Authorization", parameters.getAuthHeaderValue())
                .method(method.name(), bodyPublisher)
                .uri(URI.create("https://127.0.0.1:" + parameters.getAppPort() + relativePath))
                .build();

        try {
            return client.sendAsync(
                    request,
                    handler
            );
        } catch (Exception e) {
            log.error("Failed to send request", e);
        }
        return null;
    }

    @Override
    public HttpResponse<JsonNode> sendApiRequest(HttpMethod method, String relativePath, JsonNode body) {
        String bodyString = body == null ? null : body.toString();
        return this.sendRequest(method, relativePath, bodyString, new JsonNodeBodyHandler());
    }

    @Override
    public CompletableFuture<HttpResponse<JsonNode>> sendApiRequestAsync(HttpMethod method, String relativePath, JsonNode body) {
        String bodyString = body == null ? null : body.toString();
        return this.sendRequestAsync(method, relativePath, bodyString, new JsonNodeBodyHandler());
    }
}
