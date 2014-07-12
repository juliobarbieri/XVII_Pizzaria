<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Pizza" %>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
		<%@ page import = "java.util.ArrayList" %>
		
		<% 	Cliente cliente = (Cliente) session.getAttribute("cliente");
		
			String nome;
			
			if (cliente == null) {
				nome = "cliente";
			}
			else {
				nome = cliente.getNome();
				session.setAttribute("cliente", cliente);
			}
		%>
	
		<h1>Pizzaria do Manolo</h1>
		
		Bem-vindo <%= nome %>!<br>
		O que deseja?<br>
	 	<br>
	 	
	 	<%
			if (cliente == null) {
		%>
			<a href="login.jsp" >Login</a>
			<a href="cadastro.jsp" >Cadastro</a>
		<%	
			} else { 
		%>
			<a href="pedido.jsp" >Pedido</a>
			<!--  <a href="index.jsp" onclick="window.location=<%session.invalidate();%>'">Logout</a> -->
		<%
			}
		%>
	 	
	 	<h2>Cardápio</h2>
		
		<table border="1">
			<tr>
				<th>Pizza</th>
				<th>Ingredientes</th>
				<th>Preço</th>
			</tr>
		<%
			Pizza pizza = new Pizza();
			ArrayList<Pizza> cardapio = pizza.retireveAll();
			
			for (Pizza p : cardapio) { 
		%>
			<tr>
				<td> <%= p.getNomePizza() %> </td>
				<td> <%= p.getIngredientes() %> </td>
				<td> R$ <%= p.getPreco() %> </td>
			</tr>
		<%		
			}
		%>
		</table>
		
	</body>
</html>