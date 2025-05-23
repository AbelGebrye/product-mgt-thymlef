package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {
	
	@GetMapping("hello")
	public String sayHello(Model model) {
		
		model.addAttribute("date", new java.util.Date());
		
		return "helloworld";
	}
	

}
