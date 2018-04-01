package com.focustraining.virtualstore.domain.controller;

import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @RequestMapping(value = "/store/has", method = RequestMethod.GET)
    public boolean hasEnough(@RequestParam int productId, @RequestParam int quantity) {
        return storeService.hasEnough(productId, quantity);
    }

    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public List<ProductHolder> getStore() {
        return storeService.getStore();
    }


}
