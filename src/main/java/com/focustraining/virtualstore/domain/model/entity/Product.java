package com.focustraining.virtualstore.domain.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.focustraining.virtualstore.infrastructure.deserializer.ProductDeserializer;
import com.focustraining.virtualstore.infrastructure.serializer.ProductSerializer;
import org.springframework.stereotype.Component;

@JsonSerialize(using = ProductSerializer.class)
@JsonDeserialize(using = ProductDeserializer.class)
public class Product {

    private final int id;
    private final String name;
    private final double price;

    public Product(final int id, final String name, final double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return id == (int) obj;
        } else if (obj instanceof String) {
            return name.equalsIgnoreCase((String) obj);
        }
        return super.equals(obj);
    }
}
