package com.springpoc.springpoc.aop.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.springpoc.springpoc.aop.enums.JobStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JobDetail() {
		
	}
	
	private String id;

	private String jobName;

	private String jobUrl;
	
	private String providerJobId;

	private boolean paused;

	@DateTimeFormat(pattern = "dd/MM/yy hh:mm:ss")
	private LocalDateTime createdAt;

	@DateTimeFormat(pattern = "dd/MM/yy hh:mm:ss")
	private LocalDateTime updatedAt;

	private JobStatus jobStatus;
	
	private String cronExpression;

	private boolean deleted;
	
	private String previousRunLog;
	
	public void prePersist() {
		createdAt = updatedAt = LocalDateTime.now();
		jobStatus = JobStatus.CREATED;
	}
}
