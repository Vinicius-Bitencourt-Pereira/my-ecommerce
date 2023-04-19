package br.com.vinicius.ecommerce.entities;

public enum OrderStatus {
    WAITING_PAYMENT,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED;
}
