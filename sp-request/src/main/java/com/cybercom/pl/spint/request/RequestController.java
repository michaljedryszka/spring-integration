package com.cybercom.pl.spint.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		String message = "JCG Hello World!";
		model.addAttribute("msg", message);
		return requestService.hello(message);
	}

}