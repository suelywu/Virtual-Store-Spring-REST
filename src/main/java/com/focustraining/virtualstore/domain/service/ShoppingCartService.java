package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.entity.ShoppingCart;
import com.focustraining.virtualstore.domain.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart getShoppingCart() {
        return shoppingCartRepository.getShoppingCart();
    }

    public void addProductToShoppingCart(Product product, int quantity) {
        shoppingCartRepository.addProductToShoppingCart(product, quantity);
    }

    public void delProductFromShoppingCart(Product product, int quantity) {
        shoppingCartRepository.delProductFromShoppingCart(product, quantity);
    }

    public double getShoppingCartTotal() {
        return shoppingCartRepository.getShoppingCartTotal();
    }

}
