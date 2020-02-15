package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	String getHome() {
		return "index";
	}
	@GetMapping("/user")
	String getUser() {
		return "user";
	}
	@GetMapping("/admin")
	String getAdmin() {
		return "admin";
	}

}
