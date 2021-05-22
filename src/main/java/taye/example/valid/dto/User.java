package taye.example.valid.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taye.example.valid.annotation.YearMonth;

@NoArgsConstructor
@AllArgsConstructor

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	
	@NotBlank
	private String name;
	
	@Max(value = 90)
	private int age;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "번호 양식과 맞지 않습니다.")
	private String phoneNumber;

	@YearMonth
	private String reqYearMonth;
}
