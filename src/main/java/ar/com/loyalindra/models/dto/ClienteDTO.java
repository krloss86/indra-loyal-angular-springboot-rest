package ar.com.loyalindra.models.dto;

//POJO
public class ClienteDTO {

	private Long id;

	public ClienteDTO(Long id) {	
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
