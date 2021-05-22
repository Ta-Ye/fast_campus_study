package taye.example.filter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import taye.example.filter.dto.User;

@Slf4j
@RestController
@RequestMapping("/filter")
public class FilterController {
	
	@PostMapping("/post")
	public User user(@RequestBody User user) {
		log.info("User : {}", user);
		
		return user;
	}
}
