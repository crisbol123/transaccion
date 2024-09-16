package com.pragma.transaccion.transaccion.domain.spi;

import com.pragma.transaccion.transaccion.domain.model.Supply;

import java.util.Optional;

public interface ISupplyPersistencePort {

    void saveSupply(Supply supply);

}
