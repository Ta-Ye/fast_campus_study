package taye.example.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyError {
	
	private String field;
	private String message;
	private String invalidValue;
}
