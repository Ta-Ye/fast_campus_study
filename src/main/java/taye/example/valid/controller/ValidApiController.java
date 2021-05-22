package taye.example.valid.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taye.example.valid.dto.User;

@RestController
@RequestMapping("/valid")
public class ValidApiController {
	
	
	@PostMapping("/user")
	public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(objectError -> {
				FieldError field = (FieldError) objectError;
				
				sb.append("field : " + field.getField());
				sb.append("message : " + objectError.getDefaultMessage());
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}
		return ResponseEntity.ok(user);
	}
	
}
