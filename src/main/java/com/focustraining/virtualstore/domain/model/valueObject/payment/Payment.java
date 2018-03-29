package com.focustraining.virtualstore.domain.model.valueObject.payment;

public abstract class Payment {

    private PaymentOption paymentOption;

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public double getTotal() {
        return 0;
    }

    protected void setPaymentOption(PaymentOption option) {
        this.paymentOption = option;
    }

}
