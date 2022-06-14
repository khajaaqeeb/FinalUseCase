package com.spring.batch.process;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Items;
import com.spring.batch.repo.ItemRepository;

@Component
public class Processor implements ItemProcessor<Items, Items>{


	@Autowired
	ItemRepository itemRepository;

	@Override
	public Items process(Items item) throws Exception {

		Optional<Items>	itemFromDB = itemRepository.findById(item.getItemid());
		item.setLocaldatetime(LocalDateTime.now());

		if(itemFromDB.isPresent())
		{
			item.setAmount(item.getAmount().add(itemFromDB.get().getAmount()));
		}
		return item;
	}

}
