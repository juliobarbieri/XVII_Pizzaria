package br.com.pizzariamanolo.DAO;

import br.com.pizzariadomanolo.entidades.Cliente;


public interface ClienteDAO {
	
	public boolean cadastrarCliente(Cliente cliente);
	
	public boolean verificaExistenciaCliente(String telefone);
	
	public boolean validaCliente(Cliente cliente, String senha);

}
