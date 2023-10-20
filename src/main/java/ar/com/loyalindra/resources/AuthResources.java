package ar.com.loyalindra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.dto.LoginRequest;
import ar.com.loyalindra.models.dto.LoginResponse;

//http://localhost:8081/api/auth/login
@RestController
@RequestMapping("/api/auth")
public class AuthResources {

	@Autowired
	private AuthService authServive;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(
		@RequestBody @Validated LoginRequest request
	) {
		LoginResponse response = this.authServive.login(request.getUsername(), request.getPassword());
		
		// status code = 200
		// body : 
		return ResponseEntity.ok(response);
	}
}
