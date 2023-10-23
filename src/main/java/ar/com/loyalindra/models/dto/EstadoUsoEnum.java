package ar.com.loyalindra.models.dto;

public enum EstadoUsoEnum {
	SI,
	NO
	;
	
	public static EstadoUsoEnum getEstado(Boolean status) {
		return status ? SI : NO;
	}
}
