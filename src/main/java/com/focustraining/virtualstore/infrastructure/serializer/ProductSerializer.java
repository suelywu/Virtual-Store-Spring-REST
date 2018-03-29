package com.focustraining.virtualstore.infrastructure.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.focustraining.virtualstore.domain.model.entity.Product;

import java.io.IOException;

public class ProductSerializer extends JsonSerializer<Product> {
    @Override
    public void serialize(Product product, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("id", product.getId());
        jsonGenerator.writeObjectField("name", product.getName());
        jsonGenerator.writeObjectField("price", product.getPrice());
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }

}
