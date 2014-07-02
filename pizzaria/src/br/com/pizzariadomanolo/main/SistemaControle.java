package br.com.pizzariadomanolo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.entidades.Item;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.entidades.Pizza;

public class SistemaControle {
	
	public Cliente cliente = new Cliente();
	public Pizza pizza = new Pizza();
	public Pedido pedido = new Pedido();
	public Item item = new Item();
	
	public void cadastrar_pizza() throws IOException {
			
		String nome_pizza, ingredientes, preco;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("NOME DA NOVA PIZZA: ");
		nome_pizza = reader.readLine();
		System.out.println("INGREDIENTES DA NOVA PIZZA: ");
		ingredientes = reader.readLine();
		System.out.println("PRECO DA NOVA PIZZA: ");
		preco = reader.readLine();
		
		pizza.criaPizza(nome_pizza, ingredientes, preco);
		
		if(pizza.cadastrarPizza()) {
			System.out.println("NOVA PIZZA INSERIDA COM SUCESSO!");
			System.in.read();
		}
		else {
			System.out.println("FALHA AO INSERIR NOVA PIZZA, POR FAVOR REINSTALE O SISTEMA!");
			System.exit(-1);
		}
		
		pizza.clear();

		
	}

	public void cadastrar_pedido() throws IOException {

		String telefone, nome_pizza;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("TELEFONE DO CLIENTE: ");
		telefone = reader.readLine();
		
		cliente.criaCliente(null, telefone, null);
		
		if(cliente.buscaCliente()) {
			if (cliente.getNome() != null) {
				System.out.println("NOME: " + cliente.getNome());
				System.out.println("ENDERECO: " + cliente.getEndereco());
			}
			else {
				System.out.println("CLIENTE NÃO ENCONTRADO NOS REGISTROS!");
				return;
			}
		}
		else {
			System.out.println("FALHA AO VERIFICAR A EXISTENCIA DO CLIENTE, POR FAVOR REINSTALE O SISTEMA!");
			System.exit(-1);
		}
		
		pedido.criaPedido(telefone);		
		
		while (true) {
		
			System.out.println("PIZZA: ");
			nome_pizza = reader.readLine();
			
			pizza.setNomePizza(nome_pizza);
		
			if (pizza.buscaPizza()) {
				if (pizza.getPreco() != null) {
					System.out.println("INGREDIENTES: " + pizza.getIngredientes());
					System.out.println("PRECO: "+ pizza.getPreco());
				}
				else {
					System.out.println("PIZZA NÃO ENCONTRADA NOS REGISTROS!");
					return;
				}
			}
			else {
				System.out.println("FALHA AO VERIFICAR A EXISTENCIA DA PIZZA, POR FAVOR REINSTALE O SISTEMA!");
				System.exit(-1);
			}
			
			System.out.println("QUANTIDADE DESEJADA: ");
			int quantidade = Integer.parseInt(reader.readLine());
			
			//item.criaItem(pizza, quantidade);
			pedido.adicionarItem(pizza, quantidade);
			pizza.clear();
			item.clear();
			
			System.out.println("DESEJA INSERIR NOVOS SABORES DE PIZZA? [S/N]");
			String opcao = reader.readLine();
			if(opcao.equalsIgnoreCase("N")){
				break;
			}
		}
		
		System.out.println("CONFIRMA?[S/N]");
		String opcao = reader.readLine();
		if(opcao.equalsIgnoreCase("S")){
			
			if(pedido.cadastrarPedido()) {
				System.out.println("PEDIDO INSERIDO COM SUCESSO!");
				System.in.read();
			}
			else {
				System.out.println("FALHA AO ADICIONAR NOVO PEDIDO, POR FAVOR REINSTALE O SISTEMA!");
				System.exit(-1);
			}
		}
		
		cliente.clear();
		pizza.clear();
		pedido.clear();
		
		
	}

	public void cadastrar_cliente() throws IOException {
		
		String telefone, nome, endereco;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("TELEFONE DO NOVO CLIENTE: ");
		telefone = reader.readLine();
		System.out.println("NOME DO NOVO CLIENTE: ");
		nome = reader.readLine();
		System.out.println("ENDERECO DO NOVO CLIENTE: ");
		endereco = reader.readLine();
		
		cliente.criaCliente(nome, telefone, endereco);
		
		if(cliente.cadastrarCliente()) {
			System.out.println("CLIENTE INSERIDO COM SUCESSO!");
			System.in.read();
		}
		else {
			System.out.println("FALHA AO INSERIR NOVO CLIENTE, POR FAVOR REINSTALE O SISTEMA!");
			System.exit(-1);
		}
		
		cliente.clear();
	}
	
}
