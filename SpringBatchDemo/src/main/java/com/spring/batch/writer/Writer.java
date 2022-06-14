package com.spring.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.batch.entity.Items;
import com.spring.batch.repo.ItemRepository;

@Component
public class Writer implements ItemWriter<Items> {

	@Autowired
	ItemRepository itemRepo;

	@Override
	@Transactional
	public void write(List<? extends Items> items) throws Exception {

		itemRepo.saveAll(items);
		Thread.sleep(2000);
	}

}
