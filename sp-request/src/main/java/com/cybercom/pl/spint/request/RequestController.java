package com.cybercom.pl.spint.request;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/request")
public class RequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@Inject
	private RequestService requestService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model, @RequestParam String message) {
		if(logger.isInfoEnabled()){
			logger.info("REceived hello message: {}", message);
		}
		message = requestService.hello(message);
		model.addAttribute("msg", message);
		return message;
	}
}
