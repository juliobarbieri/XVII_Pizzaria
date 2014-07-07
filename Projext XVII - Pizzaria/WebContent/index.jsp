<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Pizza" %>
		<%@ page import = "java.util.ArrayList" %>
	
	
		Bem-vindo cliente!<br>
		O que deseja?<br>
		
		<ul>
		<%
			Pizza pizza = new Pizza();
			ArrayList<Pizza> cardapio = pizza.retireveAll();
			
			for (Pizza p : cardapio) { 
		%>
				<li> <%= p.getNomePizza() %>
		<%		
			}
		%>
		</ul>
		
		<form action="cadastro.html">
			<input type="submit" value="Pizzas">
		</form>
	</body>
</html>