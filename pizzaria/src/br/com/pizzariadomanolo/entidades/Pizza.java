package br.com.pizzariadomanolo.entidades;

public class Pizza {
	
	private String nomePizza;
	private String ingredientes;
	private Float preco;
	
	public String getNomePizza() {
		return nomePizza;
	}
	
	public String getIngredientes() {
		return ingredientes;
	}
	
	public Float getPreco() {
		return preco;
	}
	
	public void setNomePizza(String nomePizza) {
		this.nomePizza = nomePizza;
	}
	
	public void criaPizza(String nomePizza, String ingredientes, String preco) {
		this.nomePizza = nomePizza;
		this.ingredientes = ingredientes;
		this.preco = Float.parseFloat(preco);
	}
	
	public void clear() {
		this.nomePizza = null;
		this.ingredientes = null;
		this.preco = null;
	}
	

	
}
