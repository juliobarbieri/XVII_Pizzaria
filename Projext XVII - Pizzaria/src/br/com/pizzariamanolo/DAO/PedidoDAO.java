package br.com.pizzariamanolo.DAO;

import br.com.pizzariadomanolo.entidades.Pedido;

public interface PedidoDAO {
	
	public boolean cadastrarPedido(Pedido pedido);
	
	public boolean cadastraItens(Pedido pedido);

}
