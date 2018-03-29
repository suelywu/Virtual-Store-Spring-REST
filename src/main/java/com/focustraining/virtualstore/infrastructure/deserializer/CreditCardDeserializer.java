package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.focustraining.virtualstore.domain.model.valueObject.payment.CreditCard;

import java.io.IOException;

public class CreditCardDeserializer extends JsonDeserializer<CreditCard>{
    @Override
    public CreditCard deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        double total = node.get("total").asDouble();
        int cardNumber = node.get("cardNumber").asInt();
        int timesToPay = node.get("timesToPay").asInt();
        return new CreditCard(total, cardNumber, timesToPay);
    }
}
