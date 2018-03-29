package com.focustraining.virtualstore.domain.model.entity;

import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {

    private List<ProductHolder> productHolders;

    public ShoppingCart() {
        productHolders = new LinkedList<>();
    }

    public void addProduct(Product product, int quantity) {
        Optional<ProductHolder> productHolderOpt = productHolders.stream().filter(productHolder -> productHolder.getProductId() == product.getId()).findFirst();
        if (productHolderOpt.isPresent()) {
            ProductHolder productHolder = productHolderOpt.get();
            productHolder.increaseToQuantity(quantity);
        }
        ProductHolder productHolder = new ProductHolder(product, quantity);
        productHolders.add(productHolder);
    }

    public void delProduct(Product product, int quantity) {
        Optional<ProductHolder> productHolderOpt = productHolders.stream().filter(productHolder -> productHolder.getProductId() == product.getId()).findFirst();
        if (productHolderOpt.isPresent()) {
            ProductHolder productHolder = productHolderOpt.get();
            productHolder.increaseToQuantity(quantity);
        }
    }

    public double getTotal() {
        return productHolders.stream().mapToDouble(ProductHolder::getSubtotal).sum();
    }

    public List<ProductHolder> getProductHolders() {
        return Collections.unmodifiableList(productHolders);
    }

    public void clear() {
        productHolders = new LinkedList<>();
    }
}
