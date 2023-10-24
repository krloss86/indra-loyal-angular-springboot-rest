package ar.com.loyalindra.resources.recomendacion.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RecomendacionRequest {
	@NotEmpty
	private String codigo;

	private String descripcion;

	@NotEmpty
	private String nombre;

	@NotNull
	private LocalDate fechaInicio;

	private LocalDate fechaFin;

	//necesario por Spring
	public RecomendacionRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public RecomendacionRequest(String codigo, String descripcion, String nombre, LocalDate fechaInicio) {
		init(codigo, descripcion, nombre, fechaInicio);
	}

	private void init(String codigo, String descripcion, String nombre, LocalDate fechaInicio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
	}

	public RecomendacionRequest(String codigo, String descripcion, String nombre, LocalDate fechaInicio,
			LocalDate fechaFin) {
		super();
		init(codigo, descripcion, nombre, fechaInicio);
		this.fechaFin = fechaFin;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}
	
}
