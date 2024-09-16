package com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.repository;


import com.pragma.transaccion.transaccion.adapters.driven.jpa.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {



}
