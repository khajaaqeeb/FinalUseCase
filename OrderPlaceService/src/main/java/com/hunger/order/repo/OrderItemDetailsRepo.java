package com.hunger.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.order.entity.OrderItemDetailsEntity;

public interface OrderItemDetailsRepo extends JpaRepository<OrderItemDetailsEntity, Long>{

}
