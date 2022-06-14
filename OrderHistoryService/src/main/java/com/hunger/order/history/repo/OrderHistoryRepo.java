package com.hunger.order.history.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.order.history.entity.CreateOrderEntity;

public interface OrderHistoryRepo extends JpaRepository<CreateOrderEntity, Long>{

	Optional<List<CreateOrderEntity>> findTop5ByOrderByIdDesc();
	
}
