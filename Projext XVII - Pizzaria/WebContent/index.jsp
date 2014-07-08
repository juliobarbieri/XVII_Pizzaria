<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Pizza" %>
		<%@ page import = "java.util.ArrayList" %>
	
		<h1>Pizzaria do Manolo</h1>
		
		Bem-vindo cliente!<br>
		O que deseja?<br>
	 	<br>
		
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
		
		<form action="cadastro.html">
			<input type="submit" value="Pizzas">
		</form>
	</body>
</html>