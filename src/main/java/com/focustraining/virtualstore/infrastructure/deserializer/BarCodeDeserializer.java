package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.focustraining.virtualstore.domain.model.valueObject.payment.BarCode;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BarCodeDeserializer extends JsonDeserializer<BarCode> {
    @Override
    public BarCode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String field1 = node.get("field1").asText();
        String field2 = node.get("field2").asText();
        String field3 = node.get("field3").asText();
        String field4 = node.get("field4").asText();
        double total = node.get("total").asDouble();
        List<String> list = new LinkedList<>();
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        BarCode barCode = new BarCode(total);
        barCode.setBarCode(list);
        return barCode;
    }

    public BarCode deserialize2Billet(JsonNode jsonNode) {
        String field1 = jsonNode.get("field1").asText();
        String field2 = jsonNode.get("field2").asText();
        String field3 = jsonNode.get("field3").asText();
        String field4 = jsonNode.get("field4").asText();
        double total = jsonNode.get("total").asDouble();
        List<String> list = new LinkedList<>();
        list.add(field1);
        list.add(field2);
        list.add(field3);
        list.add(field4);
        BarCode barCode = new BarCode(total);
        barCode.setBarCode(list);
        return barCode;
    }
}
