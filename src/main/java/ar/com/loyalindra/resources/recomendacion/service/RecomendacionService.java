package ar.com.loyalindra.resources.recomendacion.service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.loyalindra.models.Promocion;
import ar.com.loyalindra.resources.recomendacion.repository.RecomendacionRespository;
import ar.com.loyalindra.resources.recomendacion.request.RecomendacionRequest;

@Service
public class RecomendacionService {

	@Autowired
	private RecomendacionRespository repository;
	
	public RecomendacionService(final RecomendacionRespository repository) {
		this.repository = repository;
	}
	
	public Promocion crear(RecomendacionRequest req) {
		
		//de aca con el Entity
		Promocion nuevapromo = new Promocion();
		nuevapromo.setCodigo(req.getCodigo());
		nuevapromo.setDescripcion(req.getDescripcion());
		
		//LocalDate >  Date		
		Instant instant = req.getFechaInicio().atStartOfDay(ZoneId.systemDefault()).toInstant();		
		nuevapromo.setFechaInicio(Date.from(instant));//
		
		//Date > LocalDate
		
		if(req.getFechaFin() != null) {
			instant = req.getFechaFin().atStartOfDay(ZoneId.systemDefault()).toInstant();		
			nuevapromo.setFechaFin(Date.from(instant));
		}
		
		nuevapromo.setNombre(req.getNombre());
		
		return this.repository.save(nuevapromo);
	}

	public Promocion buscarPorCodigo(String codigo) {
		return this.repository.findByCodigo(codigo);
	}

	public Promocion buscarPorId(Long id) {
		return this.repository.findById(id).orElseThrow();
	}

	public void actualizar(Promocion recomendacion) {
		this.repository.save(recomendacion);		
	}

	public void eliminar(Long id) {
		this.repository.deleteById(id);
	}
}
