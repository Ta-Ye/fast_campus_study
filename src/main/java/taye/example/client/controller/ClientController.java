package taye.example.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import taye.example.client.dto.Req;
import taye.example.client.dto.UserResponse;
import taye.example.client.service.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
	
	private final ClientService clientService; 
	
	@GetMapping("/hello")
	public Req<UserResponse> getHello() {
		return clientService.genericExchange();
	}
}
