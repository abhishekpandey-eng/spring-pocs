package com.springpoc.springpoc.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before("execution(* submitJob(..))")
	public void entering(JoinPoint joinPoint) {
		System.out.println(joinPoint.getStaticPart().getSignature().toString()+ " method is called.");
	}
}
