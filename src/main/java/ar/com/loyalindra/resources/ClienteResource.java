package ar.com.loyalindra.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.dto.ClienteDTO;
import ar.com.loyalindra.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	@Value(value = "${URL_API_EXTERNO}")
	private String mivariable;

	// permite inyectar una dependencia (spring gestiona la instancia "magicamente")
	@Autowired
	private ClienteService clienteService;

	// get: obtener todos los recursos
	//http://localhost:8081/miapp/cliente
	@GetMapping(produces = "application/json")
	public List<ClienteDTO> findAll() {
		return this.clienteService.buscarTodos();
	}

	// get: obtener un recurso
	//http://localhost:8081/miapp/cliente/2
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json", path = "/{id}")
	public ClienteDTO getById(
			@PathVariable("id") Long id
		) {
		return this.clienteService.buscarPorID(id);
	}
	
	//CREAR POST
	
	//CREAR PUT
	
	//CREAR DELETE
}
