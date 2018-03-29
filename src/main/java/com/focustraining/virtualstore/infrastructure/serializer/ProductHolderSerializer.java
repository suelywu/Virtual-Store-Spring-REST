package com.focustraining.virtualstore.infrastructure.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;

import java.io.IOException;

public class ProductHolderSerializer extends JsonSerializer<ProductHolder> {

    @Override
    public void serialize(ProductHolder productHolder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("productId", productHolder.getProductId());
        jsonGenerator.writeObjectField("quantity", productHolder.getQuantity());
        jsonGenerator.writeEndObject();
        jsonGenerator.flush();
        jsonGenerator.close();
    }
}
