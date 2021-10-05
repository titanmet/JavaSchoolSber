package com.ratnikov.lesson.ChainOfResponsibility;

public class PayPalPayment implements Payment{
    private Payment payment;
    @Override
    public void setNext(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void pay() {
        System.out.println("PayPal Payment");
    }
}
