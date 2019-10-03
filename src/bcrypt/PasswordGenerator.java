package bcrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordGenerator {

	public String generatePassword(String password) {
		String salt = BCrypt.gensalt();

		String hashedPassword = BCrypt.hashpw(password, salt);

		return hashedPassword;
	}



}
