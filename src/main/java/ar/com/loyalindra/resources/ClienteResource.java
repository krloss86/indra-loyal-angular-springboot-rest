package ar.com.loyalindra.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.dto.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	//GET
	@GetMapping(produces = "application/json")
	public ClienteDTO primerEndPointRest() {
		return new ClienteDTO(1L);
	}
}
