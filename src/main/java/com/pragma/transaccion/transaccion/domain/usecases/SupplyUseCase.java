package com.pragma.transaccion.transaccion.domain.usecases;


import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AddStockRequest;
import com.pragma.transaccion.transaccion.domain.api.ISupplyServicePort;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import com.pragma.transaccion.transaccion.domain.spi.ISupplyPersistencePort;

import com.pragma.transaccion.transaccion.domain.spi.StockFeignClientPort;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public class SupplyUseCase implements ISupplyServicePort {
    private final ISupplyPersistencePort supplyPersistencePort;
    private final StockFeignClientPort stockFeignClientPort;

    @Override
    public void saveSupply(Supply supply) {
        stockFeignClientPort.addStock(new AddStockRequest(supply.getIdArticle(), supply.getQuantity()));
        supplyPersistencePort.saveSupply(supply);
    }


}