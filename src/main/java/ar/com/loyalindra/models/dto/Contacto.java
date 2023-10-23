
package ar.com.loyalindra.models.dto;

public class Contacto {

    private String fecha;
    private String empresa;
    private String descripcion;
    
    public Contacto(String fecha, String empresa, String descripcion) {
		this.fecha = fecha;
		this.empresa = empresa;
		this.descripcion = descripcion;
	}

	public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
