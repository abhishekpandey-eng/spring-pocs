package com.springpoc.springpoc.aop.dtos.service;

import com.springpoc.springpoc.aop.dtos.JobDetailDto;
import com.springpoc.springpoc.aop.models.JobDetail;

public interface IJobService {

	public JobDetailDto submitJob(JobDetail jobDetail);
}
