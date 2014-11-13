package com.cybercom.pl.spint.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleHandler {

	private static final Logger logger = LoggerFactory.getLogger(SampleHandler.class);
			
	public String handle(String data){
		data = "[bus: " + data + "]";
		if(logger.isInfoEnabled()){
			logger.info("Handle data: {}", data);
		}
		return data;
	}
}
