package br.com.pizzariadomanolo.entidades;

public class Item {
	
	private Integer id;
	private Pizza pizza;
	private Integer quantidade;
	private Pedido pedido;
	
	public int getId() {
		return id;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public float getTotal() {
		return quantidade * pizza.getPreco();
	}
	
	public Pizza getPizza(){
		return pizza;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
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
	


}
