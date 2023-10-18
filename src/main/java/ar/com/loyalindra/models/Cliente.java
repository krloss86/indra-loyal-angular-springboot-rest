package ar.com.loyalindra.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	private Long id;
	
	@Column(name = "nombre",length = 100,nullable = false)
	private String nombre;
	
	@Column(name = "numero_telefono", length = 15,unique = true)
	private String numeroTelefono;

	public Cliente() {
		
	}
	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
}
