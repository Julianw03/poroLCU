package com.julianw03.poroLCU.model.lolChat.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.julianw03.poroLCU.model.shared.Product;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Resources {
    @Getter
    public static class ProductInformation {
        @Getter
        public static class PatchlineInformation {
            @JsonProperty("content_cookies")
            private ArrayNode           contentCookies;
            @JsonProperty("content_paths")
            private Map<String, String> contentPaths;
            private String              id;
            @JsonProperty("product_id")
            private String              productId;

            private PatchlineInformation() {}
        }

        private Product                           id;
        private String                            name;
        private Map<String, PatchlineInformation> patchlines;

        private ProductInformation() {}
    }

    private Map<Product, ProductInformation> products;

    private Resources() {}
}
