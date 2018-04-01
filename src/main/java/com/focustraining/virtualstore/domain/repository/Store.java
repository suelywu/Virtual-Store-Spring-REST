package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class Store {

    private final ProductRepository productRepository;

    private List<ProductHolder> productHolders;

    @Autowired
    public Store(ProductRepository productRepository) {
        productHolders = new LinkedList<>();
        putInStore(new ProductHolder(productRepository.findById(1), 20));
        putInStore(new ProductHolder(productRepository.findById(2), 20));
        putInStore(new ProductHolder(productRepository.findById(3), 20));
        this.productRepository = productRepository;
    }

    public List<ProductHolder> findAll() {
        return Collections.unmodifiableList(productHolders);
    }

    public boolean hasEnough(int productId, int quantity) {
        Optional<ProductHolder> productHolderOpt = productHolders.stream().filter(productHolder -> productHolder.getProductId() == productId).findFirst();
        if (productHolderOpt.isPresent()) {
            ProductHolder productHolder = productHolderOpt.get();
            if (productHolder.getQuantity() >= quantity) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void removeFromStore(ProductHolder prodHoldToRemove) {
        productHolders.stream()
        .filter(prodHold -> prodHold.equals(prodHoldToRemove))
        .findFirst().get().decreaseFromQuantity(prodHoldToRemove.getQuantity());
    }

    private void putInStore(ProductHolder productHolder) {
        productHolders.add(productHolder);
    }

    private void defaultStore() {
        if (productRepository != null) {
            System.out.printf("IT IS NULLLLLLLLLLLLL");
            if (productRepository.findById(1) != null) {
                Product product = productRepository.findById(1);
                putInStore(new ProductHolder(productRepository.findById(1), 20));
                putInStore(new ProductHolder(productRepository.findById(2), 20));
                putInStore(new ProductHolder(productRepository.findById(3), 20));
            }
        }
        Product product = productRepository.findById(1);
        putInStore(new ProductHolder(productRepository.findById(1), 20));
        putInStore(new ProductHolder(productRepository.findById(2), 20));
        putInStore(new ProductHolder(productRepository.findById(3), 20));

    }


}
