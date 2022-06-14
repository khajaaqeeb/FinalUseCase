package com.spring.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.entity.Items;
@Repository
public interface ItemRepository extends JpaRepository<Items, Long>{

}
