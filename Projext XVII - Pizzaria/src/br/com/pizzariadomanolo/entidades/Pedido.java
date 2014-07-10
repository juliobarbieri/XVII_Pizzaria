package br.com.pizzariadomanolo.entidades;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Integer id;
	private String telefone;
	private Timestamp data;
	
	private List<Item> itens;
	
	public Integer getId() {
		return id;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public Timestamp getData() {
		return data;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public void criaPedido(String telefone) {
		this.telefone = telefone;
		
		this.itens = new ArrayList<Item>();
	}

	public void clear() {
		this.telefone = null;
		this.itens = null;
	}
	
	public void adicionarItem(Pizza pizza, int quantidade) {
		Item item = new Item();
		item.criaItem(pizza, quantidade);
		itens.add(item);
	}

	public void setData(Timestamp data){
		this.data = data;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	
}
