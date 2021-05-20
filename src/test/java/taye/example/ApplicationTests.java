package taye.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import taye.example.dto.User;

@SpringBootTest
class ApplicationTests {

	@Test
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

}
