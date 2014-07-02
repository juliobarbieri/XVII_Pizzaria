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
		pedido.criaPedido("telefone", "nomePizza", 2);
		assertNotNull(pedido.getTelefone());
		assertNotNull(pedido.getNomePizza());
		assertNotNull(pedido.getQuantidade());
		
		
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
	public void getNomePizza(){
		assertNull(pedido.getNomePizza());
	}
	
	@Test
	public void getQuantidade(){
		assertNull(pedido.getQuantidade());
	}
	
	@Test
	public void clearTest(){
		pedido.clear();
		assertNull(pedido.getTelefone());
		assertNull(pedido.getNomePizza());
		assertNull(pedido.getQuantidade());
	}

}
