package com.julianw03.poroLCU.Util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public final class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    private Utils() {}

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public static Optional<String> inputStreamToString(InputStream is) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            return Optional.empty();
        }
        return Optional.of(result.toString());
    }

    public static ObjectReader getObjectReader() {
        return OBJECT_MAPPER.reader();
    }

    public static ObjectWriter getObjectWriter() {
        return OBJECT_MAPPER.writer();
    }

    public static JsonNode readObjectAsJsonNode(Object object) {
        try {
            return OBJECT_MAPPER.convertValue(object, JsonNode.class);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static <T> Optional<T> readValue(String json, Class<T> clazz) {
        try {
            return Optional.ofNullable(OBJECT_MAPPER.readValue(json, clazz));
        } catch (JsonProcessingException e) {
            log.error("Failed to parse JSON", e);
            return Optional.empty();
        }
    }

    public static <T> Optional<T> readValue(String json, TypeReference<T> ref) {
        try {
            return Optional.ofNullable(OBJECT_MAPPER.readValue(json, ref));
        } catch (JsonProcessingException e) {
            log.error("Failed to parse JSON", e);
            return Optional.empty();
        }
    }

    public static Optional<JsonNode> parseJson(String json) {
        try {
            return Optional.of(OBJECT_MAPPER.readTree(json));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

    public static Optional<ObjectNode> asObjectNode(JsonNode node) {
        if (node == null || !node.isObject()) return Optional.empty();
        return Optional.of((ObjectNode) node);
    }

    public static Optional<ArrayNode> asArrayNode(JsonNode node) {
        if (node == null || !node.isArray()) return Optional.empty();
        return Optional.of((ArrayNode) node);
    }

    public static boolean jsonKeysPresent(ObjectNode node, String... keys) {
        for (String key : keys) {
            if (node == null || !node.has(key)) return false;
        }
        return true;
    }

    public static String createPath(String basePath, String... pathParams) {
        StringBuilder sb = new StringBuilder(basePath);
        for (String s : pathParams) {
            sb.append('/');
            sb.append(s);
        }

        return sb.toString();
    }

}
