package com.pragma.transaccion.transaccion.adapters.driving.http.dto.supply.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddSupplyRequest {
    private Long idArticle;
    private int quantity;

}
