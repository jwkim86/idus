package security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwEncoder {
	public static void main(String[] args) {
		
		// 매번 다른 스트링 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String pw = "test";
		
		String result1 = encoder.encode(pw);
		String result2 = encoder.encode(pw);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(encoder.matches(pw, result1));
		System.out.println(encoder.matches(pw, result2));
	}

}
