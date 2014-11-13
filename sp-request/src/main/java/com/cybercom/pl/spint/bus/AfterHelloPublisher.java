package com.cybercom.pl.spint.bus;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AfterHelloPublisher {
	
	private static final Logger logger = LoggerFactory.getLogger(AfterHelloPublisher.class);
	
	@Inject
	private RequestGateway requestGateway;
	
	@AfterReturning(pointcut ="execution(* com.cybercom.pl.spint.request.RequestService.hello(..))", returning="returnVal")
	public void afterReturningAdvice(JoinPoint jp, String returnVal){
		if(logger.isInfoEnabled()){
			logger.info("hello completed with: {}", returnVal);
		}
		requestGateway.publish(returnVal);
	}

}
