package ar.com.loyalindra.resources.recomendacion.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RecomendacionUpdateRequest {

	@NotNull
	private Long id; 
	
	private String descripcion;

	@NotEmpty
	private String nombre;

	private LocalDate fechaFin;

	//necesario por Spring
	public RecomendacionUpdateRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
