package com.pragma.transaccion.transaccion.domain.spi;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AddStockRequest;

public interface StockFeignClientPort {
    void addStock(AddStockRequest addStockRequest);
}
