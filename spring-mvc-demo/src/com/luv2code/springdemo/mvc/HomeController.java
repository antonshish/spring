package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//controller method and mapping
	@RequestMapping("/")
	public String showPage() {
		return "main-menu"; 
		//returns view name
		//Где искать файл написано в конфиге
		//Там где suffix and prefix(что является полным именем)
		
	} 

}
