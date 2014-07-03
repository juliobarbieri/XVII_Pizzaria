package br.com.pizzariadomanolo.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sistema {
	
	public static void main(String[] args) throws IOException {
		SistemaControle controle = new SistemaControle();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String opcao = "0";
		while(!opcao.equals("4")){
			System.out.println("-----------------------");
			System.out.println("PIZZARIA DO MANOLO");
			System.out.println("-----------------------");
			System.out.println("[1] CADASTRAR NOVO CLIENTE");
			System.out.println("[2] CADASTRAR NOVO PEDIDO");
			System.out.println("[3] CADASTRAR NOVA PIZZA");
			System.out.println("[4] SAIR DA APLICAÇÃO");
			opcao = reader.readLine();
			System.out.println(opcao);
			if(opcao.equals("1")){
				controle.cadastrar_cliente();
			}
			
			if(opcao.equals("2")){
				controle.cadastrar_pedido();
			}
			
			if(opcao.equals("3")){
				controle.cadastrar_pizza();
			}
			System.in.read();
			
		}
	}

}
