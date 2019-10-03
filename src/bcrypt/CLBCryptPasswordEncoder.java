package bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CLBCryptPasswordEncoder {

	public static void main(String[] args) {

		String textPassword = args[0];

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(textPassword));
	}

}
