package br.com.pizzariadomanolo.entidades;

public class Item {
	
	Pizza pizza;
	int quantidade;
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public double getValor(){
		return pizza.getPreco();
	}

}
