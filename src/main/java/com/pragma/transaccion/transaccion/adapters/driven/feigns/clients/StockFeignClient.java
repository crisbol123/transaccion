package com.pragma.transaccion.transaccion.adapters.driven.feigns.clients;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.FeignClientConfig;
import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AddStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", url = "${stock.service.url}", configuration = FeignClientConfig.class)
public interface StockFeignClient {
    @GetMapping("/article/add-stock")
    void addStock(@RequestBody AddStockRequest addStockRequest);


}
