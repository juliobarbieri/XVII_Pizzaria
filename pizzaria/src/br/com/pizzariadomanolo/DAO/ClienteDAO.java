package br.com.pizzariadomanolo.DAO;

import br.com.pizzariadomanolo.entidades.Cliente;


public interface ClienteDAO {
	
	public boolean cadastrarCliente(Cliente cliente);
	
	public boolean buscaCliente(Cliente cliente);

}
