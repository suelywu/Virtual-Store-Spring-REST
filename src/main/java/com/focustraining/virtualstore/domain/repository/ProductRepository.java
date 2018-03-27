package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository {

    List<Product> products;

    public ProductRepository() {
        products = new LinkedList<>();
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.equals(id))
                .findFirst()
                .orElse(new Product(0, "", 0));
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(p -> p.equals(name))
                .findFirst()
                .orElse(new Product(0, "", 0));
    }

    public boolean existsById(int id) {
        return products.stream().anyMatch(p -> p.equals(id));
    }

    public boolean existsByName(String name) {
        return products.stream().anyMatch(p -> p.equals(name));
    }
}
