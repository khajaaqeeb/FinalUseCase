package com.hunger.order.history.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hunger.order.history.entity.CreateOrderEntity;
import com.hunger.order.history.repo.OrderHistoryRepo;
import com.hunger.order.history.service.impl.OrderHistoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderHistorServiceImplTest {

	@InjectMocks
	OrderHistoryServiceImpl orderService;
	
	@Mock
	OrderHistoryRepo orderRepo;
	
	@Test
	void findTop5ByOrderByIdDescTest(){
		
		CreateOrderEntity createOrder = new CreateOrderEntity("12356", 2L, new BigDecimal(335), LocalDateTime.now());
		CreateOrderEntity createOrder1 = new CreateOrderEntity("12354", 2L, new BigDecimal(335), LocalDateTime.now());
		CreateOrderEntity createOrder2 = new CreateOrderEntity("123896", 2L, new BigDecimal(335), LocalDateTime.now());
		
		Optional<List<CreateOrderEntity>> itemList =Optional.of( new ArrayList<CreateOrderEntity>());
		itemList.get().add(createOrder);
		itemList.get().add(createOrder1);
		itemList.get().add(createOrder2);
		
		when(orderRepo.findTop5ByOrderByIdDesc()).thenReturn(itemList);
		List<CreateOrderEntity> list= orderService.findTop5ByOrderByIdDesc();
		//return orderser;
		assertEquals(itemList.get().get(0).getOrderid(), list.get(0).getOrderid());	
	}
}
