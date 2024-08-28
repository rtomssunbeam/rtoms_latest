package com.app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MonitorPerformanceAspect {

	
	@Around("execution(* com.app.controller.*.*(..))")
	public Object performanceMonitor(ProceedingJoinPoint joinPoint) throws Throwable
	{
		
		long t1 = System.currentTimeMillis();
		Object result=joinPoint.proceed();
		long t2 = System.currentTimeMillis();
		
		log.info("Time taken by method : {} = {} milli seconds",joinPoint.getSignature().getName(),t2-t1);
		
		return result;
	}
	
}
