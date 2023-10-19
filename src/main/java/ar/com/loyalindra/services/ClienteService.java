package ar.com.loyalindra.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.loyalindra.models.Cliente;
import ar.com.loyalindra.models.dto.ClienteDTO;
import ar.com.loyalindra.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteDTO buscarPorID(Long id) {
		Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);
		ClienteDTO clienteDto = null;
		if(clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			System.out.println(cliente);
			clienteDto = new ClienteDTO(cliente.getId(),cliente.getNumeroTelefono(),cliente.getNombre());
		}
		return clienteDto;
	}

	public List<ClienteDTO> buscarTodos() {
		return this.clienteRepository.findAll()
				.stream()
				.map(x -> new ClienteDTO(x.getId(),x.getNumeroTelefono(),x.getNombre()))
				.collect(Collectors.toList());
	}
}
