package unitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.pizzariadomanolo.entidades.Pizza;

public class TestePizza {
	
	Pizza pizza;
	
	@Before
	public void instanciar(){
		pizza = new Pizza();
		assertNotNull(pizza);
	}
	
	@Test
	public void getNomePizzaTest() {
		assertNull(pizza.getNomePizza());
	}
	
	@Test
	public void getIngredientesTest() {
		assertNull(pizza.getIngredientes());
	}
	
	@Test
	public void getPrecoTest() {
		assertNull(pizza.getPreco());
	}
	
	@Test
	public void setNomePizzaTest() {
		pizza.setNomePizza("nomePizza");
		assertEquals("nomePizza",pizza.getNomePizza());
	}
	
	@Test
	public void criaPizza() {
		pizza.criaPizza("nomePizza", "ingredientes", "12");
		assertEquals("nomePizza",pizza.getNomePizza());
		assertEquals("ingredientes",pizza.getIngredientes());
		assertEquals(12,pizza.getPreco(),0);
	}
	
	@Test
	public void clear(){
		getIngredientesTest();
		getPrecoTest();
		getNomePizzaTest();
		criaPizza();
		pizza.clear();
		getIngredientesTest();
		getPrecoTest();
		getNomePizzaTest();
		
	}
	

}
