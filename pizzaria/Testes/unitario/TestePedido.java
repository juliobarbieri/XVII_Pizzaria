package unitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.pizzariadomanolo.entidades.Pedido;

public class TestePedido {
	Pedido pedido;
	
	@Before
	public void instanciar(){
		pedido = new Pedido();
		assertNotNull(pedido);
	}
	
	@Test
	public void criarPedidoTest(){
		pedido.criaPedido("telefone");
		assertNotNull(pedido.getTelefone());
		
		
	}
	
	@Test
	public void getIdTest(){
		assertNull(pedido.getId());
	}
	
	@Test
	public void getDataTest(){
		assertNull(pedido.getData());
	}
	
	@Test
	public void getItensTest(){
		assertNull(pedido.getItens());		
	}
	
	@Test
	public void getTelefoneTest(){
		assertNull(pedido.getTelefone());
	}
	
	@Test
	public void clearTest(){
		pedido.clear();
		assertNull(pedido.getTelefone());
	}

}
