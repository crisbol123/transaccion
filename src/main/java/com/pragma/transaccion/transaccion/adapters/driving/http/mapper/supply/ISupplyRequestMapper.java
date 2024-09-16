package com.pragma.transaccion.transaccion.adapters.driving.http.mapper.supply;


import com.pragma.transaccion.transaccion.adapters.driving.http.dto.supply.request.AddSupplyRequest;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {

    Supply addSupplyRequestToSupply(AddSupplyRequest addSupplyRequest);

}