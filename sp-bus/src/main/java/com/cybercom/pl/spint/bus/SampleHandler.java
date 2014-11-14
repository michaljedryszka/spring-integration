package com.cybercom.pl.spint.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleHandler {

	private static final Logger logger = LoggerFactory.getLogger(SampleHandler.class);

	public SIMessage handle(SIMessage requestMessage){
		String data = requestMessage.getPayload();
		data = "[bus: " + data + "]";
		if(logger.isInfoEnabled()){
			logger.info("Handle data: {}", data);
		}
		requestMessage.setPayload(data);
		return requestMessage;
	}
	/*
	public String handle(String requestMessage){
		if(logger.isInfoEnabled()){
			logger.info("Handle data string: {}", requestMessage);
		}
		return requestMessage;
	}
	*/
}
