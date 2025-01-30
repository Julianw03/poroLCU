package com.julianw03.poroLCU.connection.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.Util.Utils;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public interface LCUHttpConnector {
    <T> HttpResponse<T> sendRequest(
            HttpMethod method,
            String relativePath,
            String body,
            HttpResponse.BodyHandler<T> handler
    );

    <T> CompletableFuture<HttpResponse<T>> sendRequestAsync(
            HttpMethod method,
            String relativePath,
            String body,
            HttpResponse.BodyHandler<T> handler
    );

    HttpResponse<JsonNode> sendApiRequest(HttpMethod method, String relativePath, JsonNode body);
    CompletableFuture<HttpResponse<JsonNode>> sendApiRequestAsync(HttpMethod method, String relativePath, JsonNode body);

    default HttpResponse<JsonNode> sendApiRequest(HttpMethod method, String relativePath, Object object) {
        return sendApiRequest(method, relativePath, Utils.readObjectAsJsonNode(object));
    }
}
