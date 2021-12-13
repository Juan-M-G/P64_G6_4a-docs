package com.store.customer_ms.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super("No se encontró un cliente con " + message);
    }
}
