package com.focustraining.virtualstore.domain.service;

import com.focustraining.virtualstore.domain.model.entity.Product;
import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.repository.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final Store store;

    @Autowired
    public StoreService(Store store) {
        this.store = store;
    }

    public List<ProductHolder> getStore() {
        return store.findAll();
    }

    public boolean hasEnough(int productId, int quantity) {
        return store.hasEnough(productId, quantity);
    }

    public void removeFromStore(ProductHolder productHolder) {
        store.removeFromStore(productHolder);
    }

}
