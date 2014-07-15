package br.com.pizzariadomanolo.util;

public class Formatador {
	
	public static String retornaFormaPagamento(String value) {
		if (FormaPagamento.CREDITO.toString().equals(value)) {
			return FormaPagamento.CREDITO.getValue();
		}
		if (FormaPagamento.DINHEIRO.toString().equals(value)) {
			return FormaPagamento.DINHEIRO.getValue();
		}
		if (FormaPagamento.DEBITO.toString().equals(value)) {
			return FormaPagamento.DEBITO.getValue();
		}
		if (FormaPagamento.DINHTRC.toString().equals(value)) {
			return FormaPagamento.DINHTRC.getValue();
		}
		return "Venda por telefone";
		
	}
	
	public static String retornaValorDinheiro(Float valor) {
		return String.format("%.2f", valor);

	}

}
