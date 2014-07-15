package br.com.pizzariadomanolo.DAO;

import java.util.ArrayList;

import br.com.pizzariadomanolo.entidades.Pedido;

public interface PedidoDAO {
	
	public boolean cadastrarPedido(Pedido pedido);
	
	public boolean cadastraItens(Pedido pedido);
	
	public ArrayList<Pedido> getPedidosByTelefone(String telefone);

}
