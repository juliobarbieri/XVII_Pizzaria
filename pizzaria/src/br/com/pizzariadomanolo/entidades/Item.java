package br.com.pizzariadomanolo.entidades;

public class Item {
	
	private Integer id;
	private Pizza pizza;
	private Integer quantidade;
	
	public int getId() {
		return id;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public double getValor(){
		return pizza.getPreco();
	}
	
	public void criaItem(Pizza pizza, int quantidade) {
		this.pizza = new Pizza();
		this.pizza.criaPizza(pizza.getNomePizza(), pizza.getIngredientes(), pizza.getPreco().toString());
		this.quantidade = quantidade;

	}
	
	public void clear() {
		this.id = null;
		this.pizza = null;
		this.quantidade = null;

	}
	
	public Pizza getPizza() {
		return pizza;
	}
	

}
