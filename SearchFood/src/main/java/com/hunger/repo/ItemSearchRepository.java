package com.hunger.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunger.entity.Items;

public interface ItemSearchRepository extends JpaRepository<Items, Long>{

	Optional<List<Items>> findByCategoriesLike(String name);
	
	Optional<List<Items>> findByitemidIn(List<Long> orderItem);
}
