
package ar.com.loyalindra.models.dto;

public class ClienteDTO {

    private Saldos saldos;
    private Equipo equipo;
    private Cliente cliente;
    private Recomendaciones recomendaciones;

    public ClienteDTO(Saldos saldos, Equipo equipo, Cliente cliente, Recomendaciones recomendaciones) {
		super();
		this.saldos = saldos;
		this.equipo = equipo;
		this.cliente = cliente;
		this.recomendaciones = recomendaciones;
	}
    
    public ClienteDTO() {
		
	}

	public Saldos getSaldos() {
        return saldos;
    }

    public void setSaldos(Saldos saldos) {
        this.saldos = saldos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Recomendaciones getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(Recomendaciones recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

}
