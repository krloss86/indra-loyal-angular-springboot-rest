package ar.com.loyalindra.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ar.com.loyalindra.models.User;
import ar.com.loyalindra.models.dto.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Value(value = "JWT_SECRET_KEY")
	private String jwtSecretKey;
	
	public String generateToken(LoginResponse user) {
		//java collection framework : https://www.baeldung.com/java-collections
		Map<String, Object> claim = new HashMap<>();
		claim.put("authorities", user.getRolesDelUsuario());
		
		return Jwts.builder()
			.setClaims(claim)
			.setSubject(user.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
			.signWith(SignatureAlgorithm.HS256, this.jwtSecretKey)
			.compact();
	}
}
