package com.hunger.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.order.entity.OrderItemDetailsEntity;

public interface OrderRepository extends JpaRepository<OrderItemDetailsEntity, Long> {

}
