package taye.example.async.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import taye.example.async.service.AsyncService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/async")
public class AsyncController {
	
	private final AsyncService asyncService;
	
	@GetMapping("/hello")
	public CompletableFuture hello() {
		return asyncService.run();
	}
}
