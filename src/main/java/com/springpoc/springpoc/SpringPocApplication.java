package com.springpoc.springpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPocApplication.class, args);
	}

}
