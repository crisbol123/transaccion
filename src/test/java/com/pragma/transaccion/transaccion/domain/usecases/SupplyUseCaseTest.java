package com.pragma.transaccion.transaccion.domain.usecases;

import com.pragma.transaccion.transaccion.adapters.driven.feigns.dto.AddStockRequest;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import com.pragma.transaccion.transaccion.domain.spi.ISupplyPersistencePort;
import com.pragma.transaccion.transaccion.domain.spi.StockFeignClientPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @Mock
    private StockFeignClientPort stockFeignClientPort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSupply() {
        // Arrange
        Supply supply = new Supply(1L, 10);

        // Act
        supplyUseCase.saveSupply(supply);

        // Assert
        ArgumentCaptor<AddStockRequest> addStockRequestCaptor = ArgumentCaptor.forClass(AddStockRequest.class);
        verify(stockFeignClientPort).addStock(addStockRequestCaptor.capture());
        AddStockRequest capturedAddStockRequest = addStockRequestCaptor.getValue();
        assertEquals(1L, capturedAddStockRequest.getIdArticle());
        assertEquals(10, capturedAddStockRequest.getQuantity());

        ArgumentCaptor<Supply> supplyCaptor = ArgumentCaptor.forClass(Supply.class);
        verify(supplyPersistencePort).saveSupply(supplyCaptor.capture());
        Supply capturedSupply = supplyCaptor.getValue();
        assertEquals(1L, capturedSupply.getIdArticle());
        assertEquals(10, capturedSupply.getQuantity());
    }
}