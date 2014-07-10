package br.com.pizzariadomanolo.DAO;

import br.com.pizzariadomanolo.entidades.Pizza;

public interface PizzaDAO {

	public boolean cadastrarPizza(Pizza pizza);
	
	public boolean buscaPizza(Pizza pizza);
	
	
}
