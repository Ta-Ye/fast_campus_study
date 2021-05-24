package taye.example.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Req<T> {
	
	private Header header;
	private T httpBody;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class Header {
		private String responseCode;
	}
}
