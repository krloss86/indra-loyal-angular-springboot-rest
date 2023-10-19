package ar.com.loyalindra.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipo")
public class Equipo {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "estado_linea", nullable = false, length = 50)
	private String estadoLinea;

	@Column(name = "fabricante", nullable = false, length = 50)
	private String fabricante;

	@Column(name = "estado_uso", nullable = false, length = 50)
	private String estadoUso;

	@Column(name = "misdn", nullable = false)
	private String misdn;

	@Column(name = "imei", nullable = false)
	private String imei;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoLinea() {
		return estadoLinea;
	}

	public void setEstadoLinea(String estadoLinea) {
		this.estadoLinea = estadoLinea;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getEstadoUso() {
		return estadoUso;
	}

	public void setEstadoUso(String estadoUso) {
		this.estadoUso = estadoUso;
	}

	public String getMisdn() {
		return misdn;
	}

	public void setMisdn(String misdn) {
		this.misdn = misdn;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

//	public ClienteEquipos getClienteEquipos() {
//		return clienteEquipos;
//	}
//
//	public void setClienteEquipos(ClienteEquipos clienteEquipos) {
//		this.clienteEquipos = clienteEquipos;
//	}

	// Constructors, getters, and setters
	
}
