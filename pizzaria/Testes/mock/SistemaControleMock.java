package mock;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SistemaControleMock  {
	public ClienteTestMock cliente = new ClienteTestMock( );
	public PizzaTestMock pizza ;
	public PedidoTestMock pedido ;
	
	@Test
	public void cadastrar_pizza() throws IOException {
				
		
	}
	@Test
	public void cadastrar_pedido() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void cadastrar_cliente() throws IOException {
		ClienteTestMock cli = (ClienteTestMock) cliente;
		assertFalse(cli.getCadastro());
		cli.cadastrarCliente();
		assertTrue(cli.getCadastro());
		
	}
	
	
	

}
