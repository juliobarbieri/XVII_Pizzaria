<%@page import="br.com.pizzariadomanolo.DAO.POSTGRES.PizzaDAOPostgres"%>
<%@page import="br.com.pizzariadomanolo.DAO.PizzaDAO"%>
<html>
	<head>
		<title>Adicionar pizza</title>
		<script type="text/javascript">
			function closeSelf()
			{
    			self.close();
			}
			function onlyNumbers(e)
			{
				var key = (window.event)?event.keyCode:e.which;   
				if((key > 47 && key < 58))
					return true;
				else
				{
					if (key == 8 || key == 0) return true;
					else  return false;
				}
			}
		</script>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Pizza" %>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
		<%@ page import = "java.util.ArrayList" %>
		
		<form method="post"	action="AddPizza" onsubmit="closeSelf()">
			Selecione uma pizza:<br> 
			<select name = "pizza">   
		<% 
			PizzaDAO pizzaDAO = new PizzaDAOPostgres();
			ArrayList<Pizza> cardapio = pizzaDAO.retireveAll();
			  
		    for(Pizza p : cardapio) {  
		%> 
		        	<option value = "<%= p.getNomePizza() %>" > <%= p.getNomePizza() %></option>
		<% 
		 	}  
		%>  
		    </select>  
			<br>
			Entre com a quantidade:<br>
			<input type="text" name="quantidade" onkeypress="return onlyNumbers(event);" /><br>
			<input type="submit" value="Adicionar">
		</form>
		
		<body onunload="window.opener.location.reload()">
		
	</body>
</html>
