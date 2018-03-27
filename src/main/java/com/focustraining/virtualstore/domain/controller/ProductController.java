package com.focustraining.virtualstore.domain.controller;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.repository.ProductRepository;
import com.focustraining.virtualstore.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/products/{name}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public boolean hasProduct(@PathVariable int id) {
        return productService.hasProductById(id);
    }

    @RequestMapping(value = "/products/{name)", method = RequestMethod.GET)
    public boolean hasProduct(@PathVariable String name) {
        return productService.hasProductByName(name);
    }

}
