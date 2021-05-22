package taye.example.interceptor.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import taye.example.interceptor.exception.AuthException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AuthException.class)
	public ResponseEntity authException() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}	
