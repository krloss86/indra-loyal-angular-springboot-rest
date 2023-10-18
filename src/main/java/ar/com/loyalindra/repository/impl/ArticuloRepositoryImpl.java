package ar.com.loyalindra.repository.impl;

import ar.com.loyalindra.models.Articulo;
import ar.com.loyalindra.repository.ArticuloRepository;

public class ArticuloRepositoryImpl implements ArticuloRepository{
	//atributos para poder conectarme a la db
	public void create(Articulo articulo) {
		String sql = "insert int articulo (id) values("+articulo.getId()+")";
		System.out.println(sql);
	}
}
