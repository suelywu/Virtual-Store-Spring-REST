package com.focustraining.virtualstore.domain.model.valueObject;

import com.focustraining.virtualstore.domain.model.entity.Product;

public class ProductHolder {

    private final Product product;
    private int quantity;

    public ProductHolder(final Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void increaseToQuantity(int qtt) {
        quantity += qtt;
    }

    public void decreaseFromQuantity(int qtt) {
        if (quantity - qtt >= 0) {
            quantity -= qtt;
        }
    }

    public double getSubtotal() {
        return quantity*product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return product.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductHolder) {
            return product.getId() == ((ProductHolder) obj).getProductId();
        }
        return super.equals(obj);
    }
}
