package br.com.pizzariadomanolo.entidades;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private Integer id;
	private String telefone;
	private Timestamp data;
	private String formaPagamento;
	private Float troco;
	
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
	
	public void setData(Timestamp data){
		this.data = data;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public Float getTroco() {
		return troco;
	}
	
	public void setTroco(Float troco) {
		this.troco = troco;
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
	
	public void removerItem(String nomePizza, int quantidade) {
		Item itemParaExluir = null;
		boolean excluir = false;
		for (Item item : itens) {
			if (item.getPizza().getNomePizza().equals(nomePizza) && (item.getQuantidade() == quantidade)) {
				itemParaExluir = item;
				excluir = true;
			}
		}
		if (excluir == true) {
			itens.remove(itemParaExluir);
		}
	}


	
	
	
}
