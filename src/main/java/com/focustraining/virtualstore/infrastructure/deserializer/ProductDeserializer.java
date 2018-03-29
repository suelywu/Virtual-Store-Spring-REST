package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.focustraining.virtualstore.domain.model.entity.Product;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {
    @Override
    public Product deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final int id = node.get("id").asInt();
        final String name = node.get("name").asText();
        final double price = node.get("price").asDouble();
        return new Product(id, name, price);
    }
}
