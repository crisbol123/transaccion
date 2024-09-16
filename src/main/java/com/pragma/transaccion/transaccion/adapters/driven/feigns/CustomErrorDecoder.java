package com.pragma.transaccion.transaccion.adapters.driven.feigns;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.exception.NoNegativeStockException;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.exception.ElementNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import com.pragma.transaccion.transaccion.configuration.Constants;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {


        switch (response.status()) {
            case 409:
                return new NoNegativeStockException(Constants.NO_NEGATIVE_STOCK);
            case 404:
                return new ElementNotFoundException(Constants.ARTICLE_ID);
            default:
                return new Exception("generic error");
        }
    }
}
