package com.focustraining.virtualstore.infrastructure.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.focustraining.virtualstore.domain.model.entity.Order;

import java.io.IOException;

public class OrderDeserializer extends JsonDeserializer<Order> {
    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
    }
}
