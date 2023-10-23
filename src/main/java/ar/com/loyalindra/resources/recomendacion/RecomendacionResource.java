package ar.com.loyalindra.resources.recomendacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.loyalindra.models.dto.Recomendacion;
import ar.com.loyalindra.resources.recomendacion.request.RecomendacionRequest;
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
	@PostMapping(/*consumes = MediaType.APPLICATION_JSON,produces = MediaType.APPLICATION_JSON*/ )
	public ResponseEntity<Recomendacion> create(
			@RequestBody @Validated RecomendacionRequest request /*ResultBinding*/
		) { 
		//validaciones de negocio, fecha fin < fecha inicio
		if(request.getFechaFin() != null && request.getFechaFin().isBefore(request.getFechaInicio())) {
			//error handler
			throw new IllegalArgumentException("Fecha de fin invalida");
		}
		this.service.crear(request);
		
		//si ok 
		return ResponseEntity.created(null).build();
	}
	
	//CREAR PUT
	
	//CREAR DELETE
}
