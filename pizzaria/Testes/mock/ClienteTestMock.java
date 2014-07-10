package mock;

import br.com.pizzariadomanolo.entidades.Cliente;

public class ClienteTestMock extends Cliente{
	String telefone;
	String nome;
	String endereco;
	boolean cadastro = false;
	@Override
	public String getTelefone() {
		return telefone;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getEndereco() {
		return endereco;
	}

	@Override
	public void criaCliente(String nome, String telefone, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		
	}

	@Override
	public void clear() {
		this.nome = null;
		this.telefone = null;
		this.endereco = null;
		
	}


	public boolean cadastrarCliente() {
		this.cadastro = true;
		return false;
	}


	public boolean buscaCliente() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean getCadastro(){
		return this.cadastro;
	}
	
	

}
