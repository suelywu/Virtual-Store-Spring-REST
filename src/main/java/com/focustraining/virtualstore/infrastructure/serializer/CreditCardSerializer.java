package com.focustraining.virtualstore.infrastructure.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.focustraining.virtualstore.domain.model.valueObject.payment.CreditCard;

import java.io.IOException;

public class CreditCardSerializer extends JsonSerializer<CreditCard> {
    @Override
    public void serialize(CreditCard creditCard, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("total", creditCard.getTotal());
        jsonGenerator.writeObjectField("cardNumber", creditCard.getCardNumber());
        jsonGenerator.writeObjectField("timesToPay", creditCard.getTimesToPay());
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }

}
