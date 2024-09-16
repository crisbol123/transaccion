package com.pragma.transaccion.transaccion.domain.spi;


import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AuthorizationResponse;

public interface UserFeignClientPort {
    AuthorizationResponse validateToken(String token);
}
