<%@page import="br.com.pizzariadomanolo.util.Formatador"%>
<%@ page import = "br.com.pizzariadomanolo.entidades.Pedido" %>
<%@ page import = "br.com.pizzariadomanolo.entidades.Item" %>
<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
<%@ page import = "java.util.ArrayList" %>
<html>
	<head>
		<title>Pedido</title>
		
		<script type="text/javascript">
			function abrePopup()
			{
				window.open("addPizza.jsp", "nome", "width='200', height='200', scrollbars='no', location=no, directories=no, status=no, menubar=no, toolbar=no, resizable=no");
			}
		</script>
	</head>
	<body>
				
		<table border="1">
			<tr>
				<th>Pizza</th>
				<th>Quantidade</th>
				<th>Preço</th>
				<th>Remover</th>
			</tr>
		<%
			
			Cliente cliente = (Cliente) session.getAttribute("cliente");
			Pedido pedido = (Pedido) session.getAttribute("pedido");
			
			if (pedido == null) {
				pedido = new Pedido();
				pedido.criaPedido(cliente.getTelefone());
			}
			
			for (Item i : pedido.getItens()) { 
		%>
			<tr>
				<td> <%= i.getPizza().getNomePizza() %> </td>
				<td> <%= i.getQuantidade() %> </td>
				<td> R$ <%= Formatador.retornaValorDinheiro(i.getTotal()) %> </td>
				<td>
					<form method="post"	action="Remove">
						<input type="hidden" name="pizza" value="<%= i.getPizza().getNomePizza() %>">
						<input type="hidden" name="qnt" value="<%= i.getQuantidade() %>">
						<input type="submit" value="Remover">
					</form>
				</td>
			</tr>
		<%		
			}
		%>
		</table>
     
		<a href="javascript:abrePopup();" >Adicionar Pizzas</a>
		<a href="index.jsp" >Página inicial</a>
		<br><br>
		<a href="fecharPedido.jsp" >Fechar pedido</a>
		
	</body>
</html>