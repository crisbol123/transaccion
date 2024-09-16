package com.pragma.transaccion.transaccion.configuration;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.adapter.StockFeignClientAdapter;
import com.pragma.transaccion.transaccion.adapters.driven.feigns.adapter.UserFeignClientAdapter;
import com.pragma.transaccion.transaccion.adapters.driven.feigns.clients.StockFeignClient;
import com.pragma.transaccion.transaccion.adapters.driven.feigns.clients.UserFeignClient;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.adapter.SupplyAdapter;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.pragma.transaccion.transaccion.domain.api.ISupplyServicePort;
import com.pragma.transaccion.transaccion.domain.spi.ISupplyPersistencePort;
import com.pragma.transaccion.transaccion.domain.spi.StockFeignClientPort;
import com.pragma.transaccion.transaccion.domain.spi.UserFeignClientPort;
import com.pragma.transaccion.transaccion.domain.usecases.SupplyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
private final ISupplyEntityMapper supplyEntityMapper;
private final ISupplyRepository supplyRepository;
private final UserFeignClient userFeignClient;
private final StockFeignClient stockFeignClient;




    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }




@Bean
public UserFeignClientPort userFeignClientPort() {
    return new UserFeignClientAdapter(userFeignClient);
}


@Bean
public StockFeignClientPort stockFeignClientPort() {
    return new StockFeignClientAdapter(stockFeignClient);
}
    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), stockFeignClientPort());
    }
}