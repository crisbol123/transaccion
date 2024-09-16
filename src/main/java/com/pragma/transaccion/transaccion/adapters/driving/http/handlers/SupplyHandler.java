package com.pragma.transaccion.transaccion.adapters.driving.http.handlers;

import com.pragma.transaccion.transaccion.adapters.driving.http.dto.supply.request.AddSupplyRequest;
import com.pragma.transaccion.transaccion.adapters.driving.http.mapper.supply.ISupplyRequestMapper;
import com.pragma.transaccion.transaccion.domain.api.ISupplyServicePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SupplyHandler {
    private final ISupplyServicePort supplyServicePort;
    private final ISupplyRequestMapper iSupplyRequestMapper;

    public void saveSupply(AddSupplyRequest addSupplyRequest) {
        supplyServicePort.saveSupply( iSupplyRequestMapper.addSupplyRequestToSupply(addSupplyRequest));
    }
}
