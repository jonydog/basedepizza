package com.jpinto.basedepizza.restcontrollers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

	
	@RequestMapping("/examplerest")
	public String sayHello(HttpServletResponse response){
		
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "HELLO MAN!";
		
	}
	
	
	
	
}
