package com.ashley.springboot.webApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLoginPasge() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcome(@RequestParam String username,@RequestParam String password, ModelMap model) {
		if (username.equals("asp") && password.equals("2")) {
			model.put("name", username);
			model.put("pass", password);
			return "welcome";
			
		}
		return "login";
		
	}
	
		
	
}
