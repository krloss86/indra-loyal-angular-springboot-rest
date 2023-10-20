package ar.com.loyalindra.resources;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.loyalindra.models.UserRole;
import ar.com.loyalindra.models.User;
import ar.com.loyalindra.models.dto.LoginResponse;
import ar.com.loyalindra.repository.AuthRepository;
import ar.com.loyalindra.security.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private JwtUtils jwtUtils;
	
	public LoginResponse login(String username, String password) {
		// user es un entity
		User user = this.authRepository.findByUsername(username);

		// validar la password que esta haseada en la db con el que viene del frontend
		if (user == null || !passwordEncoder().matches(password, user.getPassword())) {
			throw new IllegalArgumentException("Username or password invalid");
		}

		Set<UserRole> roles = user.getRoles();

		// convertir los roles
		Set<String> rolesDelUsuario = roles.stream().map(r -> r.getRol()).collect(Collectors.toSet());

		// sale un dto
		LoginResponse response =  new LoginResponse(user.getId(), user.getUsername(), rolesDelUsuario);
		
		//genear el token
		String jwt = this.jwtUtils.generateToken(response);
		
		response.setJwt(jwt);
		
		return response;
	}
	
	//logout!

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
