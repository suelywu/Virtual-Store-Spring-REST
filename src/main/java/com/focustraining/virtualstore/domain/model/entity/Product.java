package com.focustraining.virtualstore.domain.model.entity;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private final int id;
    private final String name;
    private final double price;

    public Product(final int id, final String name, final double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
