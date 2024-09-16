package com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.mapper;

import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {

        @Mapping(target = "id", ignore = true)
        SupplyEntity supplyToSupplyEntity(Supply supply);

        Supply supplyEntityToSupply(SupplyEntity supplyEntity);


}
