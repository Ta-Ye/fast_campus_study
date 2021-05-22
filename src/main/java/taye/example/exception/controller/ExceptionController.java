package taye.example.exception.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import taye.example.exception.dto.User;

@RestController
@RequestMapping("/exc")
public class ExceptionController {
	
	@GetMapping("/get")
	public User get(@RequestParam(required = false) String name, @RequestParam(required = false) int age) {
		User user = new User(name, age);
		System.out.println(user);
		return user;
	}
	
	@PostMapping("/post")
	public User post(@Valid @RequestBody User user) {
		System.out.println(user);
		return user;
	}
}
