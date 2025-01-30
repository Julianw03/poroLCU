package com.julianw03.poroLCU.connection.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.Util.Either;
import com.julianw03.poroLCU.Util.Utils;

import java.net.http.HttpResponse;
import java.util.Optional;

public class LCUApiResponse<T> {
    private final HttpResponse<JsonNode> response;
    private final Either<T, LCUApiError> data;

    public LCUApiResponse(HttpResponse<JsonNode> response, Class<T> clazz) {
        this.response = response;
        if (!isSuccessful()) {
            data = Either.right(Utils.readValue(response.body().toString(), LCUApiError.class).orElse(LCUApiError.getDefault()));
            return;
        }
        // Reading the value as a Void class will return null, so we need to handle this case separately
        if (clazz == Void.class) {
            data = Either.left(null);
            return;
        }
        Optional<T> optional = Utils.readValue(response.body().toString(), clazz);
        data = optional.<Either<T, LCUApiError>>map(Either::left)
                .orElseGet(() -> Either.right(Utils.readValue(response.body().toString(), LCUApiError.class).orElse(LCUApiError.getDefault())));
    }

    public LCUApiResponse(HttpResponse<JsonNode> response, TypeReference<T> typeReference) {
        this.response = response;
        if (!isSuccessful()) {
            data = Either.right(Utils.readValue(response.body().toString(), LCUApiError.class).orElse(LCUApiError.getDefault()));
            return;
        }
        Optional<T> optional = Utils.readValue(response.body().toString(), typeReference);
        data = optional.<Either<T, LCUApiError>>map(Either::left)
                .orElseGet(() -> Either.right(Utils.readValue(response.body().toString(), LCUApiError.class).orElse(LCUApiError.getDefault())));
    }

    public HttpResponse<JsonNode> getRawResponse() {
        return response;
    }

    public Either<T, LCUApiError> getResponseBody() {
        return data;
    }

    public T getSuccessResponseBody() {
        return data.getLeft();
    }

    public LCUApiError getErrorResponseBody() {
        return data.getRight();
    }

    public boolean isSuccessful() {
        return Math.floorDiv(response.statusCode(), 100) == 2;
    }

    public boolean isErrorResponse() {
        return !isSuccessful();
    }
}
