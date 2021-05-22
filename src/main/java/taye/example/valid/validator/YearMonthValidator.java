package taye.example.valid.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import taye.example.valid.annotation.YearMonth;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String>{

	private String pattern;
	
	@Override
	public void initialize(YearMonth constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		try {
			LocalDate.parse(value, DateTimeFormatter.ofPattern(this.pattern));
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
}
