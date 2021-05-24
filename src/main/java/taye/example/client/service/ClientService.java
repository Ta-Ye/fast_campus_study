package taye.example.client.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import taye.example.client.dto.Req;
import taye.example.client.dto.UserRequest;
import taye.example.client.dto.UserResponse;

@Service
public class ClientService {

	public UserResponse hello() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090").path("/server/hello")
				.queryParam("name", "taye").queryParam("age", 26).encode().build().toUri();
		System.out.println(uri.toString());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());

		return result.getBody();
	}

	public UserResponse post() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
				.path("/server/user/{userId}/name/{userName}").encode().build().expand(100, "taye").toUri();
		System.out.println(uri);

		UserRequest req = new UserRequest("taye", 26);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());

		return response.getBody();
	}

	public UserResponse exchange() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
				.path("/server/user/{userId}/name/{userName}").encode().build().expand(100, "taye").toUri();
		System.out.println(uri);

		UserRequest req = new UserRequest("taye", 26);
		RequestEntity<UserRequest> requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "abcd").header("custom-header", "fffff").body(req);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
		return response.getBody();
	}

	public Req<UserResponse> genericExchange() {
		URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
				.path("/server/user/{userId}/name/{userName}").encode().build().expand(100, "taye").toUri();
		System.out.println(uri);

		UserRequest userRequest = new UserRequest("taye", 26);

		Req<UserRequest> req = new Req<>();
		req.setHeader(new Req.Header("안녕하세요"));
		req.setHttpBody(userRequest);

		RequestEntity<Req<UserRequest>> requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "abcd").header("custom-header", "fffff").body(req);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Req<UserResponse>>() {
				});
		
		return response.getBody();
	}

}
