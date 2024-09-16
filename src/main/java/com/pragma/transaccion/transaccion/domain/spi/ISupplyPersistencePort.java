package com.pragma.transaccion.transaccion.domain.spi;

import com.pragma.transaccion.transaccion.domain.model.Supply;

public interface ISupplyPersistencePort {

    void saveSupply(Supply supply);

}
