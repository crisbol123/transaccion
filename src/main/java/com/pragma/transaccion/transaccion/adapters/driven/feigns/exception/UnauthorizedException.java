package com.pragma.transaccion.transaccion.adapters.driven.feigns.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
