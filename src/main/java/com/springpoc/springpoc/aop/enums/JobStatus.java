package com.springpoc.springpoc.aop.enums;

public enum JobStatus {

	CREATED(0), SUCCESS(1), FAILED(2);
	
	int value;
	
	public int getValue() {
		return value;
	}
	
	JobStatus(int value){
		this.value = value;
	}
}