package taye.example.interceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;
import taye.example.interceptor.interceptor.AuthInterceptor;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
	
	
	private final AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/intercept/private/*");
	}
}
