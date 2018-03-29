package com.focustraining.virtualstore.domain.model.valueObject.payment;

import java.util.List;

public class Billet extends Payment {

    private BarCode barCode;
    private final double total;

    public Billet(final double total) {
        this.total = total;
        barCode = new BarCode(total);
        setPaymentOption(PaymentOption.BILLET);
    }

    public void setBarCode(BarCode barCode) {
        this.barCode = barCode;
    }

    public BarCode getBarCode() {
        return barCode;
    }

    public List<String> getBarCodeList() {
        return barCode.getBarCode();
    }

    @Override
    public double getTotal() {
        return total;
    }
}
