package taye.example.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taye.example.interceptor.annotation.Auth;

@RestController
@RequestMapping("/intercept/private")
@Auth
public class PrivateController {
	
	@GetMapping("/hello")
	public String hello() {
		return "private hello";
	}

}
