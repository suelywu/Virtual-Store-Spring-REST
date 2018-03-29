package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class Store {

    @Autowired
    private ProductRepository productRepository;

    private List<ProductHolder> productHolders;

    public Store() {
        productHolders = new LinkedList<>();
        defaultStore();
    }

    public boolean hasEnought(Product product, int quantity) {
        Optional<ProductHolder> productHolderOpt = productHolders.stream().filter(productHolder -> productHolder.getProductId() == product.getId()).findFirst();
        if (productHolderOpt.isPresent()) {
            ProductHolder productHolder = productHolderOpt.get();
            if (productHolder.getQuantity() >= quantity) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void defaultStore() {
        productHolders.add(new ProductHolder(productRepository.findById(1), 20));
        productHolders.add(new ProductHolder(productRepository.findById(2), 20));
        productHolders.add(new ProductHolder(productRepository.findById(3), 20));
        productHolders.add(new ProductHolder(productRepository.findById(4), 20));
    }


}
