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
			<input type="text" name="quantidade" onkeypress="return onlyNumbers(event);" /><br>
			<input type="submit" value="AddPizza">
		</form>
		
		<body onunload="window.opener.location.reload()">
		
	</body>
</html>
