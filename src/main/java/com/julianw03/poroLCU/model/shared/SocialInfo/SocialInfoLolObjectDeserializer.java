package com.julianw03.poroLCU.model.shared.SocialInfo;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class SocialInfoLolObjectDeserializer extends JsonDeserializer<SocialInfo.LolObject> {
    @Override
    public SocialInfo.LolObject deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.readValueAsTree();
        if (!node.isObject()) return null;
        ObjectNode object = (ObjectNode) node;
        //Sadly if there is no information available Riot chooses to represent that as an empty object, instead of null
        if (!object.fields().hasNext()) return null;

        return new ObjectMapper().treeToValue(object, SocialInfo.LolObject.class);
    }
}
