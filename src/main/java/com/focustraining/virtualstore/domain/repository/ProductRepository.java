package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new LinkedList<>();
        defaultProductRepositoryContent();
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.equals(id))
                .findFirst()
                .orElse(new Product(0, "", 0));
    }

    public Product findByName(String name) {
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

    private void defaultProductRepositoryContent() {
        products.add(new Product(1, "mesa", 300));
        products.add(new Product(2, "camiseta", 30));
        products.add(new Product(3, "caneca", 30));
    }

}
