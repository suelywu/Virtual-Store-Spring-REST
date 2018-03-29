package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.focustraining.virtualstore.domain.model.valueObject.payment.BarCode;
import com.focustraining.virtualstore.domain.model.valueObject.payment.Billet;

import java.io.IOException;

public class BilletDeserializer extends JsonDeserializer<Billet> {
    @Override
    public Billet deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final double total = node.get("total").asDouble();
        JsonNode barCodeNode = node.get("barCode");
        BarCodeDeserializer barCodeDeserializer = new BarCodeDeserializer();
        BarCode barCode = barCodeDeserializer.deserialize2Billet(barCodeNode);
        Billet billet = new Billet(total);
        billet.setBarCode(barCode);

        return billet;
    }
}
