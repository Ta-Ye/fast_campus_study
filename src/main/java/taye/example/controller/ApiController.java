package taye.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
