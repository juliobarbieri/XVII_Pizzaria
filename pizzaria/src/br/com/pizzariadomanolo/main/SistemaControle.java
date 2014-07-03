package br.com.pizzariadomanolo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.entidades.Pizza;
import br.com.pizzariadomanolo.util.Validator;

public class SistemaControle {
	
	public Cliente cliente = new Cliente();
	public Pizza pizza = new Pizza();
	public Pedido pedido = new Pedido();
	
	public void cadastrar_pizza() throws IOException {
			
		String nome_pizza, ingredientes, preco;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("NOME DA NOVA PIZZA: ");
		nome_pizza = reader.readLine();
		System.out.println("INGREDIENTES DA NOVA PIZZA: ");
		ingredientes = reader.readLine();
		System.out.println("PRECO DA NOVA PIZZA: ");
		preco = reader.readLine().replace(",", ".");
		
		if (!Validator.isString(ingredientes) || !Validator.isString(nome_pizza)) {
			System.out.println("NOME DA PIZZA OU INGREDIENTES EM FORMATO INCORRETO!");
			return;
		}
		
		if (!Validator.isFloat(preco)) {
			System.out.println("PREÇO EM FORMATO INCORRETO!");
			return;
		}
		
		pizza.criaPizza(nome_pizza, ingredientes, preco);
		
		if(pizza.cadastrarPizza()) {
			System.out.println("NOVA PIZZA INSERIDA COM SUCESSO!");
		}
		else {
			System.out.println("FALHA AO INSERIR NOVA PIZZA!\nCAUSA: NOME DA PIZZA JÁ EXISTENTE.");
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
			System.out.println("FALHA AO VERIFICAR A EXISTENCIA DO CLIENTE!");
			return;
		}
		
		pedido.criaPedido(telefone);		
		
		String opcao = "S";
		while (!opcao.equalsIgnoreCase("N")) {
		
			System.out.println("PIZZA: ");
			nome_pizza = reader.readLine();
			
			pizza.setNomePizza(nome_pizza);
		
			if (pizza.buscaPizza()) {
				if (pizza.getPreco() != null) {
					System.out.println("INGREDIENTES: " + pizza.getIngredientes());
					System.out.println("PRECO: " + pizza.getPreco());
				}
				else {
					System.out.println("PIZZA NÃO ENCONTRADA NOS REGISTROS!");
					return;
				}
			}
			else {
				System.out.println("FALHA AO VERIFICAR A EXISTENCIA DA PIZZA!");
				return;
			}
			
			System.out.println("QUANTIDADE DESEJADA: ");
			String qntString = reader.readLine();
			
			if (!Validator.isInteger(qntString)) {
				System.out.println("QUANTIDADE EM FORMATO INCORRETO!");
				return;
			}
			
			int quantidade = Integer.parseInt(qntString);
			
			pedido.adicionarItem(pizza, quantidade);
			pizza.clear();
			
			System.out.println("DESEJA INSERIR NOVOS SABORES DE PIZZA? [S/N]");
			opcao = reader.readLine();
		}
		
		System.out.println("CONFIRMA?[S/N]");
		opcao = reader.readLine();
		if(opcao.equalsIgnoreCase("S")){
			
			if(pedido.cadastrarPedido()) {
				System.out.println("PEDIDO INSERIDO COM SUCESSO!");
			}
			else {
				System.out.println("FALHA AO ADICIONAR NOVO PEDIDO!");
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
		
		if (!Validator.isString(telefone) || !Validator.isString(nome) || !Validator.isString(endereco)) {
			System.out.println("TELEFONE, NOME OU ENDERECO EM FORMATO INCORRETO!");
			return;
		}
		
		cliente.criaCliente(nome, telefone, endereco);
		
		if(cliente.cadastrarCliente()) {
			System.out.println("CLIENTE INSERIDO COM SUCESSO!");
		}
		else {
			System.out.println("FALHA AO INSERIR NOVO CLIENTE!\nCAUSA: TELEFONE JÁ EXISTENTE.");
		}
		
		cliente.clear();
	}
	
}
