package ar.com.loyalindra.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.loyalindra.models.Cliente;
import ar.com.loyalindra.models.Equipo;
import ar.com.loyalindra.models.dto.ClienteDTO;
import ar.com.loyalindra.models.dto.Contacto;
import ar.com.loyalindra.models.dto.DatosEquipo;
import ar.com.loyalindra.models.dto.DatosSaldo;
import ar.com.loyalindra.models.dto.EstadoUsoEnum;
import ar.com.loyalindra.models.dto.Recomendacion;
import ar.com.loyalindra.models.dto.Recomendaciones;
import ar.com.loyalindra.models.dto.Saldos;
import ar.com.loyalindra.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteDTO buscarPorID(Long id) {
		Optional<Cliente> clienteOptional = this.clienteRepository.findById(id);
		ClienteDTO clienteDto = new ClienteDTO();
		if(clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			
			clienteDto = fromClienteEntityToClienteDto(cliente);
		}
		
		return clienteDto;
	}

	private ClienteDTO fromClienteEntityToClienteDto(Cliente cliente) {
		//recomendaciones > recomendaciones
		List<Recomendacion> recomendacionesList = cliente.getClientePromocion().stream()
			.map(x -> new Recomendacion(x.getNombre(),x.getCodigo(),x.getDescripcion())) //function intermedia
			.collect(Collectors.toList());//funcione terminal
		
		Recomendaciones recomendaciones = new Recomendaciones(recomendacionesList);
		
		//equipo > datosEquipo
		Equipo equipo = cliente.getClienteEquipos().iterator().next(); //primer elemento del Set
		List<DatosEquipo> datosEquipo = new ArrayList<>();
		datosEquipo.add(new DatosEquipo("Estado Linea", equipo.getEstadoLinea()));
		datosEquipo.add(new DatosEquipo("Estado Uso", EstadoUsoEnum.getEstado(equipo.getEstadoUso()).toString()));
		datosEquipo.add(new DatosEquipo("Fabricante", equipo.getFabricante()));
		datosEquipo.add(new DatosEquipo("IMEI", equipo.getImei()));
		datosEquipo.add(new DatosEquipo("MISDN", equipo.getMisdn()));
		
		ar.com.loyalindra.models.dto.Equipo equipoDto = new ar.com.loyalindra.models.dto.Equipo(datosEquipo);
		
		//cliente > datosSaldos
		List<DatosSaldo> datosSaldo = cliente.getClienteSaldos().stream()
		.map(x -> new DatosSaldo(x.getDescripcion(), x.getFecha().toString(), x.getDescripcion()))//
		.collect(Collectors.toList());
		
		Saldos saldo = new Saldos(datosSaldo);
		
		//cliente > conctacto
		List<Contacto> contactos = cliente.getClientePromocion().stream()
				.map(x -> new Contacto(x.getFechaInicio().toString(),"CLARO",x.getDescripcion() + " " + x.getCodigo())) //function intermedia
				.collect(Collectors.toList());//funcione terminal
			
		ar.com.loyalindra.models.dto.Cliente clienteDto = new ar.com.loyalindra.models.dto.Cliente(contactos);
		return new ClienteDTO(saldo,equipoDto, clienteDto,  recomendaciones);
	}

	public List<ClienteDTO> buscarTodos() {
		return this.clienteRepository.findAll()
				.stream()
				.map(x -> fromClienteEntityToClienteDto(x))
				.collect(Collectors.toList());
	}
	
	
}
