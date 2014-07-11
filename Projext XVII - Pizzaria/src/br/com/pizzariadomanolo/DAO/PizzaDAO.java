package br.com.pizzariadomanolo.DAO;

import java.util.ArrayList;

import br.com.pizzariadomanolo.entidades.Pizza;

public interface PizzaDAO {

	public boolean cadastrarPizza(Pizza pizza);
	
	public ArrayList<Pizza> retireveAll();
	
	public boolean buscaPizza(Pizza pizza);
	
	
}
