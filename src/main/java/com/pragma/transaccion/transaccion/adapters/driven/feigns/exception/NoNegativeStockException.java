package com.pragma.transaccion.transaccion.adapters.driven.feigns.exception;

public class NoNegativeStockException extends RuntimeException {
    public NoNegativeStockException(String message) {
        super(message);
    }

}
