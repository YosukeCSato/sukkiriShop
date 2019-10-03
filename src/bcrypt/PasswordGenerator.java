package bcrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordGenerator {

	public String generatePassword(String password) {
		String salt = BCrypt.gensalt();

		String hashedPasswordWithSalt = BCrypt.hashpw(password, salt);

		return hashedPasswordWithSalt;
	}



}
