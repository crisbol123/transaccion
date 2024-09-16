package com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.adapter;

import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.pragma.transaccion.transaccion.domain.model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class SupplyAdapterTest {

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private ISupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyAdapter supplyAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSupply() {
        // Arrange
        Supply supply = new Supply(1L, 10);
        SupplyEntity supplyEntity = new SupplyEntity();
        supplyEntity.setIdArticle(1L);
        supplyEntity.setQuantity(10);

        // Mock the mapper behavior
        org.mockito.Mockito.when(supplyEntityMapper.supplyToSupplyEntity(supply)).thenReturn(supplyEntity);

        // Act
        supplyAdapter.saveSupply(supply);

        // Assert
        ArgumentCaptor<SupplyEntity> supplyEntityCaptor = ArgumentCaptor.forClass(SupplyEntity.class);
        verify(supplyRepository).save(supplyEntityCaptor.capture());
        SupplyEntity capturedSupplyEntity = supplyEntityCaptor.getValue();
        assertEquals(1L, capturedSupplyEntity.getIdArticle());
        assertEquals(10, capturedSupplyEntity.getQuantity());
        assertEquals(LocalDate.now(), capturedSupplyEntity.getDate());
    }
}