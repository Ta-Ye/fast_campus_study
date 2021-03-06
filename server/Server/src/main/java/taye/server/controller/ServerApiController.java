package taye.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import taye.server.dto.Req;
import taye.server.dto.User;

@Slf4j
@RestController
@RequestMapping("/server")
public class ServerApiController {

	@GetMapping("/hello")
	public User hello(@RequestParam("name") String name, @RequestParam("age") int age) {
		return new User(name, age);
	}

	@PostMapping("/user/{userId}/name/{userName}")
	public Req<User> post(
			@RequestBody Req<User> user, 
			@PathVariable("userId") int userId,
			@PathVariable("userName") String userName,
			@RequestHeader("x-authorization") String authorization,
			@RequestHeader("custom-header") String customheader) {
		
		
		log.info("userId :{}, userName :{}", userId, userName);
		log.info("authorization : {}, custom-header : {}", authorization, customheader);
		log.info("client req : {}", user);
		
		Req<User> response = new Req<>();
		response.setHeader(
				new Req.Header("?ȳ??ϼ???.")
		);
		response.setHttpBody(user.getHttpBody());
		
		
		return response;
	}
	
	
}
