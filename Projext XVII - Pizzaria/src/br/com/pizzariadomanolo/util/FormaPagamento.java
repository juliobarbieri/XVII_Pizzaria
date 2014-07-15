package br.com.pizzariadomanolo.util;

public enum FormaPagamento {
	CREDITO("Cartão de Crédito"),
	DINHEIRO("Dinheiro"),
	DEBITO("Débito"),
	DINHTRC("Dinheiro com troco");
	
	private final String value;
	
	private FormaPagamento(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
