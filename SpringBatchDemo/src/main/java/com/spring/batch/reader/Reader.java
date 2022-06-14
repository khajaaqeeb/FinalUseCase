package com.spring.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import com.spring.batch.entity.Items;


public class Reader extends FlatFileItemReader<Items>{

	public Reader(Resource resource) {
	
		
		super();
		setResource(resource);
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setNames(new String[] {"itemid","itemname","itemdescription","amount","categories"});
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);

		BeanWrapperFieldSetMapper<Items> beanWrapperFieldSetMapper= new  BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(Items.class);
		
	
		DefaultLineMapper<Items> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(tokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		
		setLineMapper(defaultLineMapper);
	}
}
