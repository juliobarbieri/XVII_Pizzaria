package unitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.pizzariadomanolo.entidades.Cliente;

public class TesteCliente {
	Cliente cliente;
	
	@Before
	public void instanciar(){
		cliente = new Cliente();
		assertNotNull(cliente);
	}
	
	@Test
	public void getTelefoneTest(){
		assertNull(cliente.getTelefone());	
	}

	@Test
	public void getNomeTest(){
		assertNull(cliente.getNome());	
	}

	@Test
	public void getEndereco(){
		assertNull(cliente.getEndereco());	
	}

	@Test
	public void criaClienteTest() {
		cliente.criaCliente("nome", "telefone", "endereco", "senha");
		assertEquals(cliente.getNome(),"nome");
		assertEquals(cliente.getTelefone(),"telefone");
		assertEquals(cliente.getEndereco(),"endereco");
		assertEquals(cliente.getSenha(), "senha");
	}

	@Test
	public void clearTest(){
		cliente.clear();
		assertNull(cliente.getNome());
		assertNull(cliente.getTelefone());
		assertNull(cliente.getEndereco());
	}



}
