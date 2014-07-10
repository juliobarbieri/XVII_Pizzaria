package br.com.pizzariadomanolo.entidades;

public class Cliente{
	
	private String telefone;
	private String nome;
	private String endereco;

	public String getTelefone() {
		return telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void criaCliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void clear() {
		this.nome = null;
		this.telefone = null;
		this.endereco = null;
	}
	
	
}
