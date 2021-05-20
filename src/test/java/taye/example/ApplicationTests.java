package taye.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import taye.example.dto.User;
import taye.example.ioc.Base64Encoder;
import taye.example.ioc.Encoder;
import taye.example.ioc.UrlEncoder;

@SpringBootTest
class ApplicationTests {

	void contextLoads() throws JsonProcessingException {
		
		// Text JSON -> Object
		// Object -> Text JSON
		
		// controller req json(Text) -> object
		// respopnse object -> json(text)
		
		ObjectMapper obm = new ObjectMapper();
		
		// object -> text
		// get method 이용
		
		User user = User.builder().name("taye").age(26).build();
		String s = obm.writeValueAsString(user);
		System.out.println(s);
		
		// text -> object
		// default 생성자 이용
		User oUser = obm.readValue(s, User.class);
		System.out.println(oUser);
	}
	
	
	
	// IoC, DI 공부
	@Test
	public void test() {
		
		String url = "www.naver.com/books/it?page-10&size-20&name=spring-boot";
		
		// Base 64로 인코딩
		Encoder encoder = new Encoder(new Base64Encoder());
		String result = encoder.encode(url);
		System.out.println(result);
		
		// url encoding
		Encoder urlEncoder = new Encoder(new UrlEncoder());
		String result2 = urlEncoder.encode(url);
		System.out.println(result2);
		
		
	}

}