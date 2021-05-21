package taye.example.aop;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import taye.example.dto.User;

@Aspect
@Component
public class DecodeAop {
	
	@Pointcut("execution(* taye.example.aop.controller..*.*(..))")
	private void cut() {}
	
	@Pointcut("@annotation(taye.example.aop.annotation.Decode)")
	private void enableDecode() {}
	
	@Before("cut() && enableDecode")
	public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			if(arg instanceof User) {
				User user = User.class.cast(arg);
				String base64Email = user.getAddress();
				String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
				user.setAddress(email);
			}
		}
	}
	
	@AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
	public void afterReturn(JoinPoint joinPoint, Object returnObj) {
		if(returnObj instanceof User) {
			User user = User.class.cast(returnObj);
			String email = user.getAddress();
			String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
			user.setAddress(base64Email);
		}
	}
}
