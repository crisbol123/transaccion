package com.pragma.transaccion.transaccion.adapters.driven.feigns.adapter;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.clients.StockFeignClient;
import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AddStockRequest;
import com.pragma.transaccion.transaccion.domain.spi.StockFeignClientPort;

public class StockFeignClientAdapter implements StockFeignClientPort {
    private final StockFeignClient stockFeignClient;

    public StockFeignClientAdapter(StockFeignClient stockFeignClient) {
        this.stockFeignClient = stockFeignClient;
    }

    @Override
    public void addStock(AddStockRequest addStockRequest) {
        stockFeignClient.addStock(addStockRequest);
    }
}
