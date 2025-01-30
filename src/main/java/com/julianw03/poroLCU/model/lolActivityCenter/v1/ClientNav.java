package com.julianw03.poroLCU.model.lolActivityCenter.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.julianw03.poroLCU.model.shared.iso8601Date.ISO8601Date;
import lombok.Getter;

import java.util.List;

@Getter
public class ClientNav {
    @Getter
    public static class Data {
        @Getter
        public static class Elements {
            //TODO: Implement the rest of the fields
            private JsonNode    action;
            private JsonNode    background;
            private ISO8601Date createdAt;
            private ISO8601Date endsAt;
            private JsonNode    icon;
            private String      id;
            private String      navigationItemId;
            private JsonNode    products;
            private String      title;
            private ISO8601Date updatedAt;

            private Elements() {
            }
        }

        private List<Elements> elements;

        private Data() {
        }
    }

    private Data data;

    private ClientNav() {
    }
}
