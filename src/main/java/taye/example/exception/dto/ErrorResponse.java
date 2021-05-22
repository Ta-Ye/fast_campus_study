package taye.example.exception.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
	
	String statusCode;
	String requestUrl;
	String code;
	String message;
	String resultCode;
	
	List<MyError> errorList;
	
}
