package com.focustraining.virtualstore.domain.controller;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.entity.ShoppingCart;
import com.focustraining.virtualstore.domain.service.ProductService;
import com.focustraining.virtualstore.domain.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public ShoppingCart getShoppingCart() {
        return shoppingCartService.getShoppingCart();
    }
/*
    @RequestMapping(value = "/shoppingCart/total", method = RequestMethod.GET)
    public double getShoppingCartTotal() {
        return shoppingCartService.getShoppingCartTotal();
    }
*/

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.PUT)
    public void addProductToShoppingCart(@RequestParam int productId, @RequestParam int quantity) {
        Product product = productService.getProductById(productId);
        shoppingCartService.addProductToShoppingCart(product, quantity);
    }

    @RequestMapping(value = "/shoppingCart", method = RequestMethod.DELETE)
    public void delProductFromShoppingCart(@RequestBody Product product, @RequestParam int quantity) {
        shoppingCartService.delProductFromShoppingCart(product, quantity);
    }

}
