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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Authentication",description = "Servicio para generar token de autenticacion")
//http://localhost:8081/api/auth/login
@RestController
@RequestMapping("/api/auth")
public class AuthResources {

	@Autowired
	private AuthService authServive;
	
	@Operation(
			summary = "Genera un token jwt",
			description = "Descripcion adicional",
			tags= {"auth","post","pepe"}
	)	
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				content = {
						@Content(
							schema = @Schema(implementation = LoginResponse.class),mediaType = "aplication/json"
						)						
				}
		),
		@ApiResponse(
				responseCode = "404",
				content = {@Content(
					schema = @Schema() 
				)}
		),
		@ApiResponse(
				responseCode = "500",
				content = {@Content(
					schema = @Schema() 
				)}
			)
	})	
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
