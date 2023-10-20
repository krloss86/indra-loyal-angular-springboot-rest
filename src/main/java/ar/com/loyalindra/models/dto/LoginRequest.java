package ar.com.loyalindra.models.dto;

import jakarta.validation.constraints.NotEmpty;

public class LoginRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return this.username;
	}
}
