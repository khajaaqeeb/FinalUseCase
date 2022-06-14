package com.hunger.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunger.entity.Items;
import com.hunger.entity.OrderItemDetailsEntity;
import com.hunger.exception.MenuItemsNotFoundException;
import com.hunger.repo.ItemSearchRepository;
import com.hunger.service.ItemSearchService;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

	private static final Logger logger
			= org.apache.logging.log4j.LogManager.getLogger(ItemSearchServiceImpl.class);
	@Autowired
	ItemSearchRepository itemRepository;

	

	@Override
	public List<Items> findByCategoriesLike(String name) {
		Optional<List<Items>> opitems=itemRepository.findByCategoriesLike(name);
		if (opitems.isPresent()) {
			return opitems.get();
		}
		throw new MenuItemsNotFoundException("Menu items not present!");

	}

	@Override
	public Integer totalAmount(List<OrderItemDetailsEntity> orderItem) {
		
		List<Long> id = orderItem.stream().map(x->x.getItemid()).collect(Collectors.toList());
		if(id == null || id.isEmpty())
		{
			throw new MenuItemsNotFoundException("Menu items not present!");
		}
		Optional<List<Items>> itemList = itemRepository.findByitemidIn(id);
		if(itemList.isPresent())
		{
			return orderItem.stream().map( x -> calculateTotalAmount(x,itemList.get())).reduce(0, Integer::sum);
				
		}
		
		throw new MenuItemsNotFoundException("Menu items not present! with id :- " + id); 
	}

	private static Integer calculateTotalAmount(OrderItemDetailsEntity order ,List<Items> items)
	{
		Integer i=0;
		try {
			i=  (order.getQnty() * items.get(order.getItemid().intValue()).getAmount());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return i;
	}
}
