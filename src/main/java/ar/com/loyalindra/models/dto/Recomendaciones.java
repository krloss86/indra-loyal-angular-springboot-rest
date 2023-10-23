
package ar.com.loyalindra.models.dto;

import java.util.List;

public class Recomendaciones {

    private List<Recomendacion> recomendacions;

    public Recomendaciones(List<Recomendacion> recomendacions) {
		super();
		this.recomendacions = recomendacions;
	}

	public List<Recomendacion> getRecomendaciones() {
        return recomendacions;
    }

    public void setRecomendaciones(List<Recomendacion> recomendacions) {
        this.recomendacions = recomendacions;
    }

}
