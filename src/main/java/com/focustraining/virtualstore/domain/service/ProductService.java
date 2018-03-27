package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public boolean hasProductById(int id) {
        return productRepository.existsById(id);
    }

    public boolean hasProductByName(String name) {
        return productRepository.existsByName(name);
    }



}
