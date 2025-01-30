package com.julianw03.poroLCU.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;

public class JsonNodeBodyHandler implements HttpResponse.BodyHandler<JsonNode> {
    @Override
    public HttpResponse.BodySubscriber<JsonNode> apply(HttpResponse.ResponseInfo responseInfo) {
        return new HttpResponse.BodySubscriber<>() {
            private final HttpResponse.BodySubscriber<String> wrapped = HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);

            @Override
            public CompletionStage<JsonNode> getBody() {
                return wrapped.getBody()
                        .thenApply(str -> {
                            try {
                                return Utils.getObjectReader().readTree(str);
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                                return null;
                            }
                        });
            }

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                wrapped.onSubscribe(subscription);
            }

            @Override
            public void onNext(List<ByteBuffer> item) {
                wrapped.onNext(item);
            }

            @Override
            public void onError(Throwable throwable) {
                wrapped.onError(throwable);
            }

            @Override
            public void onComplete() {
                wrapped.onComplete();
            }
        };
    }
}
