package ar.com.loyalindra.resources.recomendacion;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.Promocion;
import ar.com.loyalindra.models.dto.Recomendacion;
import ar.com.loyalindra.resources.recomendacion.request.RecomendacionRequest;
import ar.com.loyalindra.resources.recomendacion.request.RecomendacionUpdateRequest;
import ar.com.loyalindra.resources.recomendacion.service.RecomendacionService;

@RestController
@RequestMapping("/api/recomendacion")
public class RecomendacionResource {

	@Autowired
	private final RecomendacionService service;
	
	public RecomendacionResource(final RecomendacionService service) {
		this.service = service;
	}
	
	//CREAR POST
	@PostMapping(consumes = "application/json", produces = "application/json" )
	public ResponseEntity<Recomendacion> create(
			@RequestBody @Validated RecomendacionRequest request /*ResultBinding*/
		) throws URISyntaxException { 
		//validaciones de negocio, fecha fin < fecha inicio
		if(request.getFechaFin() != null && request.getFechaFin().isBefore(request.getFechaInicio())) {
			//error handler
			throw new IllegalArgumentException("Fecha de fin invalida");
		}
		
		//antes de crearlo verificamos si ya existe!
		Promocion recomendacion = this.service.buscarPorCodigo(request.getCodigo());
		
		if(recomendacion == null) {			
			this.service.crear(request);
		}
		
		//si ok 
		URI uri = new URI("/api/recomendacion/"+recomendacion.getId()); 
		return ResponseEntity.created(uri).build();
	}
	
	//CREAR PUT
	@PutMapping("/{id}")
	public ResponseEntity<?> update(
			@PathVariable(name="id", required = true) Long id,
			@RequestBody @Validated RecomendacionUpdateRequest request /*ResultBinding*/
		) throws URISyntaxException { 
		
		//validar
		if(!request.getId().equals(id)) {
			return ResponseEntity.badRequest().body(request);
		}
		
		//antes de crearlo verificamos si ya existe!
		Promocion recomendacion = this.service.buscarPorId(request.getId());
		
		//actualizo
		recomendacion.setDescripcion(request.getDescripcion());
		recomendacion.setNombre(request.getNombre());

		if(request.getFechaFin() != null) {
			Instant instant = request.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant();		
			recomendacion.setFechaFin(Date.from(instant));
		}
	
		this.service.actualizar(recomendacion);
		
		return ResponseEntity.ok().build();
	}
	
	//CREAR DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(
			@PathVariable("id") Long id
			) { 
		this.service.eliminar(id);
		return ResponseEntity.ok().build();
	}
}	
