package taye.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import taye.example.ioc.ApplicationContextProvider;
import taye.example.ioc.Base64Encoder;
import taye.example.ioc.Encoder;
import taye.example.ioc.UrlEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();
		
		//Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		//UrlEncoder urlEncoder = context.getBean(UrlEncoder.class); 
		
		Encoder encoder = context.getBean("base64Encode", Encoder.class);
		System.out.println(encoder.encode("www.naver.com/books/it?page-10&size-20&name=spring-boot"));
	}

}

@Configuration
class AppConfig {
	
	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}
	
	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
}
