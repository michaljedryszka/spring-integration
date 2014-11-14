package com.cybercom.pl.spint.bus;

public class SIMessageTransformer {
	
	public SIMessage transform(String message){
		return new SIMessage(message);
	}
}
