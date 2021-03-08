package com.ga.doctorapp.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API {
	@GetMapping("/home")
	public String hello() {
		return "Welcome to the Doctor App";
	}
}
