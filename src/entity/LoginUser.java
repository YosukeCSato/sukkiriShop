package entity;

public class LoginUser implements java.io.Serializable {

	private String userId;
	private String pass;

	public LoginUser() {

	}

	public LoginUser(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getPass() {
		return this.pass;
	}

}
