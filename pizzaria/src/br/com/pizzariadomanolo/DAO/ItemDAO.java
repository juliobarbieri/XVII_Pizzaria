package br.com.pizzariadomanolo.DAO;

import br.com.pizzariadomanolo.entidades.Item;


public interface ItemDAO {
	
	public boolean cadastrarItem(Integer idPedido, Item item);
		
}
