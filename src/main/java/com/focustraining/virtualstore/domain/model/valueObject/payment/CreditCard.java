package com.focustraining.virtualstore.domain.model.valueObject.payment;

public class CreditCard extends Payment{

    private final double total;
    private final int cardNumber;
    private final int timesToPay;

    public CreditCard(final double total,
                      final int cardNumber,
                      final int timesToPay) {
        this.total = total;
        this.cardNumber = cardNumber;
        this.timesToPay = timesToPay;
        setPaymentOption(PaymentOption.CREDIT_CARD);
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getTimesToPay() {
        return timesToPay;
    }

    public double getValorParcela() {
        return total/timesToPay;
    }

    @Override
    public double getTotal() {
        return total;
    }
}
