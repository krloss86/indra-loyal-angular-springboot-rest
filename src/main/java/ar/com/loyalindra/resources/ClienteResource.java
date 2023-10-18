package ar.com.loyalindra.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.Cliente;
import ar.com.loyalindra.models.dto.ClienteDTO;
import ar.com.loyalindra.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	@Value(value = "${URL_API_EXTERNO}")
	private String mivariable;

	// permite inyectar una dependencia (spring gestiona la instancia "magicamente")
	@Autowired
	private ClienteRepository clienteRepositoy;

	// get: obtener todos los recursos
	//http://localhost:8081/miapp/cliente
	@GetMapping(produces = "application/json")
	public List<ClienteDTO> findAll() {

		List<Cliente> clientes = this.clienteRepositoy.findAll();

		//map de los java stream + lambda
		
		List<ClienteDTO> list = new ArrayList<>();
		for(var x : clientes) {
			list.add(new ClienteDTO(x.getId(),x.getNumeroTelefono(),x.getNombre()));
		}
		
		return list;
	}

	// get: obtener un recurso
	//http://localhost:8081/miapp/cliente/2
	@GetMapping(produces = "application/json", path = "/{id}")
	public ClienteDTO getById(
			@PathVariable("id") Long id
		) {

		System.out.println("getById");
		Optional<Cliente> clienteOptional = this.clienteRepositoy.findById(id);

		ClienteDTO clienteDto = null;
		if(clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			System.out.println(cliente);
			clienteDto = new ClienteDTO(cliente.getId(),cliente.getNumeroTelefono(),cliente.getNombre());
		}
		
		return clienteDto;
	}
}
