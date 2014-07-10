<html>
	<head>
		<title>Pedido</title>
	</head>
	<body>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Item" %>
		<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
		<%@ page import = "java.util.ArrayList" %>
				
		<table border="1">
			<tr>
				<th>Pizza</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Remover</th>
			</tr>
		<%
			ArrayList<Item> itens = new ArrayList<Item>();
			
			for (Item i : itens) { 
		%>
			<tr>
				<td> <%= i.getPizza().getNomePizza() %> </td>
				<td> <%= i.getQuantidade() %> </td>
				<td> R$ <%= i.getTotal() %> </td>
				<td><a>Remover</a></td>
			</tr>
		<%		
			}
		%>
		</table>
		
		<a href="addPizza.jsp" target="blank">Adicionar Pizzas</a>
		
	</body>
</html>