package com.ashley.springboot.webApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHello {
	
	@RequestMapping("/h")
	@ResponseBody
	public String sayHello() {
		return "hello. how are you";
	}

	@RequestMapping("/helloj")
	public String sayHelloJSP() {
		return "hello";
	}
}
