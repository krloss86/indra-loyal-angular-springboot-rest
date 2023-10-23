
package ar.com.loyalindra.models.dto;

public class Recomendacion {

    private String titulo;
    private String subTitulo;
    private String descripcion;
    
    public Recomendacion(String titulo, String subTitulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.descripcion = descripcion;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
