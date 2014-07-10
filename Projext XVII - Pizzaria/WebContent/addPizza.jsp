<html>
	<head>
		<title>Adicionar pizza</title>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Pizza" %>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
		<%@ page import = "java.util.ArrayList" %>
		
		<form method="post"	action="Adiciona">
			Selecione uma pizza:<br> 
			<select name = "pizzas">   
		<% 
			Pizza pizza = new Pizza();
			ArrayList<Pizza> cardapio = pizza.retireveAll();
			  
		    for(Pizza p : cardapio) {  
		%> 
		        	<option value = <%= p.getNomePizza() %> > <%= p.getNomePizza() %></option>
		<% 
		 	}  
		%>  
		    </select>  
			<br>
			Entre com a quantidade:<br>
			<input type="text" name="quantidade" /><br>
			<input type="submit" value="Adiciona">
		</form>
		
	</body>
</html>
