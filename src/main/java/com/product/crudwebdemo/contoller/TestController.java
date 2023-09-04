package com.product.crudwebdemo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") //http://localhost:8080/test
public class TestController {
	
	@Autowired
	private Environment env;

	@GetMapping
	public String sayHello() {
		return "Hello World!";
	}
}

