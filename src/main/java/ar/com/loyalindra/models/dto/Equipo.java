
package ar.com.loyalindra.models.dto;

import java.util.List;

public class Equipo {

    private List<DatosEquipo> datosEquipo;

    public Equipo(List<DatosEquipo> datosEquipo) {
		this.datosEquipo = datosEquipo;
	}

	public List<DatosEquipo> getDatosEquipo() {
        return datosEquipo;
    }

    public void setDatosEquipo(List<DatosEquipo> datosEquipo) {
        this.datosEquipo = datosEquipo;
    }

}
