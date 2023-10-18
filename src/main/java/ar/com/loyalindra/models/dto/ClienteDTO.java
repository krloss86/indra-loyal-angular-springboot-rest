package ar.com.loyalindra.models.dto;

//POJO
public class ClienteDTO {

	private Long id;
	private String telefono;
	private String nombre;

	public ClienteDTO(Long id) {	
		this.id = id;
	}

	public ClienteDTO(Long id, String telefono, String nombre) {
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
