package ar.com.loyalindra.services;

import ar.com.loyalindra.models.Articulo;
import ar.com.loyalindra.repository.ArticuloRepository;
import ar.com.loyalindra.repository.impl.ArticuloRepositoryImpl;

public class ArticuloService {

	private ArticuloRepository repository;
	
	public ArticuloService() {
		this.repository = new ArticuloRepositoryImpl();
	}
	
	//metodos de servicio
	public void crearArticulo(Articulo articulo) {
		this.repository.create(articulo);
	}
}
