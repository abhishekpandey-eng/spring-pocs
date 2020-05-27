package com.springpoc.springpoc.aop.dtos.service.impl;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.activemq.broker.scheduler.CronParser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.springpoc.springpoc.aop.dtos.JobDetailDto;
import com.springpoc.springpoc.aop.dtos.service.IJobService;
import com.springpoc.springpoc.aop.models.JobDetail;

@Service
public class JobServiceImpl implements IJobService {

	private Map<String, JobDetail> jobDetails;
	
	@PostConstruct
	private void init() {
		jobDetails = new HashMap<String, JobDetail>();
	}
	
	@Override
	public JobDetailDto submitJob(JobDetail jobDetail) {
		JobDetailDto response = new JobDetailDto(true);

		validateRequest(jobDetail, response);

		if (!response.isSuccess())
			return response;

		return addJob(jobDetail, response);
	}
	
	private void validateRequest(JobDetail jobDetail, JobDetailDto response) {

		if (StringUtils.isEmpty(jobDetail.getJobName())) {
			response.setSuccess(false);
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("job name must not be empty !!");
			return;
		}

		if (StringUtils.isEmpty(jobDetail.getJobUrl())) {
			response.setSuccess(false);
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("job url must not be empty !!");
			return;
		}

		if (StringUtils.isEmpty(jobDetail.getCronExpression())
				|| !validateCronExpression(jobDetail.getCronExpression())) {
			response.setSuccess(false);
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("job cron expression must not be empty and invalid !!");
			return;
		}
		
		if(jobDetails.containsKey(jobDetail.getJobUrl())) {
			response.setSuccess(false);
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("job already exist against provided url");
			return;
		}
	}
	
	private boolean validateCronExpression(String cronEntry) {
		try {
			CronParser.validate(cronEntry);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	private JobDetailDto addJob(JobDetail jobDetail, JobDetailDto response) {
		jobDetails.put(jobDetail.getJobUrl(), jobDetail);
		response.setSuccess(true);
		response.setStatus(HttpStatus.CREATED);
		response.setMessage("job created successfully !!");
		return response;
	}


}
