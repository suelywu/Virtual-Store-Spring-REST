package com.focustraining.virtualstore.domain.repository;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.entity.ShoppingCart;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRepository {

    private ShoppingCart shoppingCart;

    public ShoppingCartRepository() {
        shoppingCart = new ShoppingCart();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public double getShoppingCartTotal() {
        return shoppingCart.getTotal();
    }

    public void addProductToShoppingCart(Product product, int quantity) {
        shoppingCart.addProduct(product, quantity);
    }

    public void delProductFromShoppingCart(Product product, int quantity) {
        shoppingCart.delProduct(product, quantity);
    }
}
