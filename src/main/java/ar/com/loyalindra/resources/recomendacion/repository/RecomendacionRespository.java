package ar.com.loyalindra.resources.recomendacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.loyalindra.models.Promocion;

@Repository
public interface RecomendacionRespository extends JpaRepository<Promocion, Long>{

	//query method: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	//select * from promocion where codigo = 'ac123'
	public Promocion findByCodigo(String codigo);
}
