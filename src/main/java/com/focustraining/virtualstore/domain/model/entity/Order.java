package com.focustraining.virtualstore.domain.model.entity;

import com.focustraining.virtualstore.domain.model.valueObject.ProductHolder;
import com.focustraining.virtualstore.domain.model.valueObject.payment.Payment;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Order {

    private final int id;
    private final Client client;
    private final LocalDateTime dateTime;
    private final List<ProductHolder> productHolders;
    private final Payment payment;

    public Order(int id, Client client, List<ProductHolder> productHolders, Payment payment) {
        this.id = id;
        this.client = client;
        dateTime = LocalDateTime.now();
        this.productHolders = productHolders;
        this.payment = payment;
    }

    public int getClientId() {
        return client.getId();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<ProductHolder> getProductHolders() {
        return Collections.unmodifiableList(productHolders);
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return id==(int) obj;
        }
        return super.equals(obj);
    }
}
