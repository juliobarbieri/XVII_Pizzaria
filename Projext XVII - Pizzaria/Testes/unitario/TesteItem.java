package unitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pizza;
public class TesteItem {
	Item item;
	
	@Before
	public void instanciar(){
		item = new Item();
		assertNotNull(item);
	}	

		
	@Test
	public void criarItemTest(){
		item.criaItem(new Pizza(), 5);
		assertNotNull(item);
		assertEquals(5,item.getQuantidade());
		
	}
	

	

	

}
