package com.julianw03.poroLCU.model.lolActivityCenter.v1;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;

import java.util.List;

@Getter
public class ContentData {
    @Getter
    public static class Analytics {
        private String contentId;
        private String contentLocale;
        private String publishDate;
        private String rev;

        private Analytics() {
        }
    }

    private Analytics      analytics;
    //TODO: Implement Blade class
    private List<JsonNode> blades;
    private String         id;
    private String         locale;
    private String         title;
    private String         translationId;
    private String         type;

    private ContentData() {
    }
}
