package com.hunger.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.order.entity.PlaceOrderEntity;

public interface PlaceOrderRepository extends JpaRepository<PlaceOrderEntity, Long>{

}
