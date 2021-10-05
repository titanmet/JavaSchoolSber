package com.ratnikov.lesson.ChainOfResponsibility;

public interface Payment {
    void setNext(Payment payment);
    void pay();
}
