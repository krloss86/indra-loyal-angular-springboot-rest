package ar.com.loyalindra.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="rol",unique = true, length = 50)
	private String rol;

	public UserRole() {		
	}
	
	public UserRole(Long id, String rol) {
		this.id = id;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public String getRol() {
		return rol;
	}
}
