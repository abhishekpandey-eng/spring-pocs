package com.springpoc.springpoc.aop.dtos;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobDetailDto {

	public JobDetailDto() {

	}

	public JobDetailDto(boolean success) {
		this.success = success;
	}

	private boolean success;

	private HttpStatus status;

	private String message;
}
