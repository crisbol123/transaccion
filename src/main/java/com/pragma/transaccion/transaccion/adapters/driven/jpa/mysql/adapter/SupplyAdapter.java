package com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.adapter;


import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import com.pragma.transaccion.transaccion.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyRepository supplyRepository;
private final ISupplyEntityMapper supplyEntityMapper;
    @Override
    public void saveSupply(Supply supply) {
        SupplyEntity supplyEntity = supplyEntityMapper.supplyToSupplyEntity(supply);
supplyEntity.setDate(LocalDate.now());
        supplyRepository.save(supplyEntity);
    }






}
