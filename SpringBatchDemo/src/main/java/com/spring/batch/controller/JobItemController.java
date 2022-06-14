package com.spring.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class JobItemController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("itemJob")
	Job itemJob;

	@GetMapping("/run-batch-job")
	public String handle() throws Exception {
		JobParameters jobParameter = new JobParametersBuilder()
				.addString("source", "Spring Boot")
				.toJobParameters();

		jobLauncher.run(itemJob, jobParameter);

		return "Batch Job has been invoked";
	}

}
