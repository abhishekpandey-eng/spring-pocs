package com.springpoc.springpoc.aop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springpoc.springpoc.aop.dtos.JobDetailDto;
import com.springpoc.springpoc.aop.dtos.service.IJobService;
import com.springpoc.springpoc.aop.models.JobDetail;

@RestController
@RequestMapping("/jobs")
public class MISController {

	@Autowired
	private IJobService jobService;

	@PostMapping(value = { "", "/" })
	public ResponseEntity<JobDetailDto> submitJob(@RequestBody JobDetail jobDetail) {
		JobDetailDto jobDetailResponse = jobService.submitJob(jobDetail);
		return new ResponseEntity<JobDetailDto>(jobDetailResponse, jobDetailResponse.getStatus());
	}
}
