package ar.com.loyalindra.models.dto;

import java.util.Set;

//dto que va al cliente
public class LoginResponse {

	private Long id;
	private String username; 
	private Set<String> rolesDelUsuario;
	private String jwt;
	
	public LoginResponse(Long id,String username, Set<String> rolesDelUsuario) {
		this.id = id;
		this.username = username;
		this.rolesDelUsuario = rolesDelUsuario;
	}

	public String getUsername() {
		return username;
	}

	public Set<String> getRolesDelUsuario() {
		return rolesDelUsuario;
	}

	public Long getId() {
		return id;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
}
