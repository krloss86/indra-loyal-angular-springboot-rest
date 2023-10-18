package ar.com.loyalindra.models;

public class Articulo {
	private Long id;

	public Articulo(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + "]";
	}
}
