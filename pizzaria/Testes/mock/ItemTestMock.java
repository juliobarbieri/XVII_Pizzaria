package mock;

import static org.junit.Assert.*;

import org.junit.Test;


public class ItemTestMock  {
	Integer id;
	PizzaTestMock pizza;
	Integer quantidade;
	
	 
	public int getId() {
		return id;
	}

	 
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return quantidade;
	}

	 
	public double getValor() {
		return pizza.getPreco();
	}

	 
	public void criaItem(PizzaTestMock pizza, int quantidade) {
		this.pizza = pizza;
		this.pizza.criaPizza(pizza.getNomePizza(), pizza.getIngredientes(), pizza.getPreco().toString());
		this.quantidade = quantidade;
		
	}

	 
	public void clear() {
		id = null;
		pizza = null;
		quantidade = null;
		
	}
	
	public PizzaTestMock criarPizza(){
		PizzaTestMock pizza = new PizzaTestMock();
		pizza.criaPizza("nome", "ingredientes", "10");
		return pizza;
	}

	
	public boolean cadastrarItem(Integer idPedido) {
		this.id=idPedido;
		PizzaTestMock pizza = criarPizza();
		criaItem(pizza, 10);
		return true;
	}
	
	@Test
	public void cadastrarItem(){
		assertNull(pizza);
		assertNull(id);
		assertNull(quantidade);
		cadastrarItem(15);
		assertNotNull(pizza);
		assertEquals(id, 15, 0);
		assertEquals(quantidade, 10, 0);
		
		
	}

}
