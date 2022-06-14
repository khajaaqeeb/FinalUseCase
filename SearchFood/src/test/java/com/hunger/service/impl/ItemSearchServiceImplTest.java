package com.hunger.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hunger.entity.Items;
import com.hunger.entity.OrderItemDetailsEntity;
import com.hunger.repo.ItemSearchRepository;

@ExtendWith(MockitoExtension.class)
 class ItemSearchServiceImplTest {


	@InjectMocks
	ItemSearchServiceImpl itemSearch;
	
	@Mock
	ItemSearchRepository itemRepo;
	
	@Test
	 void findByCategoriesLikeTest()
	{
		Items item = new Items(1L, "Chicken", "Chicken", 500, "mainCourse", LocalDateTime.now());
		Items item1 = new Items(2L, "Chicken Biryani", "Chicken Biryani", 500, "mainCourse", LocalDateTime.now());
		Optional<List<Items>> itemList =Optional.of( new ArrayList<Items>());
		itemList.get().add(item);
		itemList.get().add(item1);

		when(itemRepo.findByCategoriesLike("mainCourse")).thenReturn(itemList);
	
		
		List<Items> itemListService = itemSearch.findByCategoriesLike("mainCourse");
		assertEquals("Chicken", itemListService.get(0).getItemname());
		
	}

	
}
