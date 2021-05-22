package taye.example.exception.advice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.cfg.defs.EANDef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import taye.example.exception.dto.ErrorResponse;
import taye.example.exception.dto.MyError;

//@RestControllerAdvice
public class GlobalControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(Exception e) {
		System.out.println(e.getClass().getName());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		List<MyError> errorList = new ArrayList<>();
		
		e.getBindingResult().getAllErrors().forEach(error -> {
			FieldError field = (FieldError) error;
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			String value = field.getRejectedValue().toString();
			
			MyError errorMessage = new MyError();
			errorMessage.setField(fieldName);
			errorMessage.setMessage(message);
			errorMessage.setInvalidValue(value);
			
			errorList.add(errorMessage);
		});
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(errorList);
		errorResponse.setMessage("");
		errorResponse.setRequestUrl(request.getRequestURI());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setResultCode("FAIL");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity constraintViolationException(ConstraintViolationException e) {
		
		e.getConstraintViolations().forEach(error -> {
			error.getPropertyPath();
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e) {
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		System.out.println(fieldName);
		System.out.println(fieldType);
		System.out.println(invalidValue);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
