package taye.example.exception.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import taye.example.exception.dto.User;

@RestController
@RequestMapping("/exc")
@Validated
public class ExceptionController {
	
	@GetMapping("/get")
	public User get(
			@Size(min=2)
			@RequestParam String name,
			
			@NotNull
			@Min(1)
			@RequestParam int age) {
		
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
