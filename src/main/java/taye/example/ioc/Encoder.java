package taye.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Component
public class Encoder {
	
	private IEncoder iEncoder;
	
	public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder) {
		this.iEncoder = iEncoder;
	}
	public String encode(String message) {
		return iEncoder.encode(message);
	}
}
