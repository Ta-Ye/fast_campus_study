package taye.example.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import taye.example.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello spring boot";
	}
	
	@GetMapping("/get/hello/{name}")
	public String getHello(@PathVariable("name") String pathName) {
		return "get Hello " + pathName;
	}
	
	@GetMapping("query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach( entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		return sb.toString();
	}
	
	//////////////////////////////////////////
	
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	
	@PostMapping("/json")
	public User json(@RequestBody User user) {
		return user;
	}
	
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
