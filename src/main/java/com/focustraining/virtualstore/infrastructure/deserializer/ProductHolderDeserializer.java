package com.focustraining.virtualstore.infrastructure.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ProductHolderDeserializer extends JsonDeserializer<ProductHolder>{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductHolder deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int productId = node.get("productId").asInt();
        int quantity = node.get("quantity").asInt();
        Product product = productRepository.findById(productId);
        return new ProductHolder(product, quantity);
    }
}
