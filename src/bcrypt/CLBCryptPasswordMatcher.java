package bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CLBCryptPasswordMatcher {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String textPassword = args[0];
		String encryptedPassword = args[1];

		if (encoder.matches(textPassword, encryptedPassword)) {
			System.out.println("mached");
		} else {
			System.out.println("unmatched");
		}
	}

}
