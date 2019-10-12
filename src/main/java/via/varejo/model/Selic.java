package via.varejo.model;

import java.math.BigDecimal;

public class Selic {
	private String data;
	private BigDecimal valor;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	

}
