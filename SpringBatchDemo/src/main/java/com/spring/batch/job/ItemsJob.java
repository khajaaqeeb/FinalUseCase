package com.spring.batch.job;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.Items;
import com.spring.batch.process.Processor;
import com.spring.batch.reader.Reader;
import com.spring.batch.writer.Writer;

@Component
public class ItemsJob extends JobExecutionListenerSupport {

	@Autowired
	JobBuilderFactory builderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Value("${input.file}")
	Resource resource;
	
	@Autowired
	Processor processor;
	
	@Autowired
	Writer writer;
	
	@Bean(name = "itemJob")
	public Job itemsJob() {
		
		Step step = stepBuilderFactory.get("step-1")
				.<Items,Items>chunk(2)
				.reader(new Reader(resource))
				.processor(processor)
				.writer(writer)
				.build();
		
		
		Job job = builderFactory.get("item-Job")
				.incrementer(new RunIdIncrementer())
				.listener(this)
				.start(step)
				.build();
	
		return job;
		
	}
	
	
	@Override
	public void afterJob(JobExecution jobExecution) {

		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}
}
