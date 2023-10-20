
package ar.com.loyalindra.models.dto;

import java.util.List;

public class Recomendaciones {

    private List<Recomendacione> recomendaciones;

    public Recomendaciones(List<Recomendacione> recomendaciones) {
		super();
		this.recomendaciones = recomendaciones;
	}

	public List<Recomendacione> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Recomendacione> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

}
