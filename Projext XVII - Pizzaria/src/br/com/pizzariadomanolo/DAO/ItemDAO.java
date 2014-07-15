package br.com.pizzariadomanolo.DAO;

import java.util.ArrayList;

import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pedido;


public interface ItemDAO {
	
	public boolean cadastrarItem(Integer idPedido, Item item);

	public ArrayList<Item> getItensByPedido(Pedido pedido);
		
}
