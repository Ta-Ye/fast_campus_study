package taye.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import taye.example.dto.User;

@Controller
public class PageController {
	
	@RequestMapping("/main")
	public String main() {
		return "main.html";
	}
	
	@ResponseBody
	@GetMapping("/user")
	public User user() {
		User user = new User();
		user.setName("steve");
		user.setAge(10);
		return user;
	}
}
