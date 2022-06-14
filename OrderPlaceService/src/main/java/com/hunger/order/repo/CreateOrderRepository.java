package com.hunger.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.order.entity.CreateOrderEntity;

public interface CreateOrderRepository extends JpaRepository<CreateOrderEntity, Long> {

}
