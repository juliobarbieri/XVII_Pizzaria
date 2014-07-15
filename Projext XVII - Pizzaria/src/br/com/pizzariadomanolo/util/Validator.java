package br.com.pizzariadomanolo.util;

public class Validator {
	
	public static String retornaValor(String value) {
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

}
