
package ar.com.loyalindra.models.dto;

public class DatosEquipo {

    private String titulo;
    private String dato;
    
    public DatosEquipo(String titulo, String dato) {
		this.titulo = titulo;
		this.dato = dato;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
