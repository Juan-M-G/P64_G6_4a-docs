package com.grupo6.bill_ms.exceptions;
public class BillNotFoundException extends RuntimeException {
    public BillNotFoundException(String message) {
        super(message);
    }
}

