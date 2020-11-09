package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controoler method to show HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm()  {
		return "helloworld";
	}
	
	//method for read form data
	/*@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		//read req param from html form
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		
		//на именно имя message будет ссылаться JSP 
		model.addAttribute("message", name);
		
		return "helloworld";
	}*/
	@RequestMapping("/processFormVersionThree")
	public String processForm3(
			@RequestParam("studentName") String name, 
			Model model) {
		name = name.toUpperCase();
		//на именно имя message будет ссылаться JSP 
		model.addAttribute("message", name);
		
		return "helloworld";
	}
}
