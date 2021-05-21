package taye.example.aop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import taye.example.aop.annotation.Decode;
import taye.example.aop.annotation.Timer;
import taye.example.dto.User;

@RestController
@RequestMapping("/aop/api")
public class RestApiController {
	
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return id + " " + name; 
	}
	
	@PostMapping("/post")
	public User post(@RequestBody User user) {
		return user;
	}
	
	@Timer
	@DeleteMapping("/delete")
	public void delete() throws InterruptedException{
		Thread.sleep(1000*2);
	}
	
	@Decode
	@PutMapping("/put")
	public User put(@RequestBody User user) {
		System.out.println("put : " + user);
		return user;
	}
}
