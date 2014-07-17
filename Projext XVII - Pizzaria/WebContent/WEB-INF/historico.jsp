<%@ page import = "br.com.pizzariadomanolo.util.Formatador"%>
<%@ page import = "br.com.pizzariadomanolo.util.FormaPagamento"%>
<%@ page import = "br.com.pizzariadomanolo.DAO.POSTGRES.PedidoDAOPostgres"%>
<%@ page import = "br.com.pizzariadomanolo.DAO.PedidoDAO"%>
<%@ page import = "br.com.pizzariadomanolo.entidades.Pedido" %>
<%@ page import = "br.com.pizzariadomanolo.entidades.Item" %>
<%@ page import = "br.com.pizzariadomanolo.entidades.Cliente" %>
<%@ page import = "java.util.ArrayList" %>
<html>
	<head>
		<title>Histórico de Pedidos</title>
	</head>
	<body>
		
		<%
			Cliente cliente = (Cliente) session.getAttribute("cliente");	
				
			PedidoDAO pedidoDAO = new PedidoDAOPostgres();
			ArrayList<Pedido> pedidos = pedidoDAO.getPedidosByTelefone(cliente.getTelefone());
		%>
		
		<table border="1">
		<tr>
			<th>Data e Hora</th>
			<th>Forma de Pagamento</th>
			<th>Troco</th>
			<th>Pizzas</th>
		</tr>
		
		<%
			for (Pedido pedido : pedidos) {
		%>
			<tr>
				<td> <%=pedido.getData()%> </td>
				<td> <%=Formatador.retornaFormaPagamento(pedido.getFormaPagamento())%> </td>
				<td> R$ <%= Formatador.retornaValorDinheiro(pedido.getTroco()) %> </td>
				
				<td>
				<table border="1">
				<tr>
					<th>Pizza</th>
					<th>Quantidade</th>
					<th>Valor Total</th>
				</tr>
				<%
					for (Item item : pedido.getItens()) {
				%>
						<tr>
							<td> <%= item.getPizza().getNomePizza() %> </td>
							<td> <%= item.getQuantidade() %> </td>
							<td> R$ <%= Formatador.retornaValorDinheiro(item.getTotal()) %> </td>
						</tr>
				<%
					}
				%>
				</table>
				<strong>Total pago:</strong> R$ <%= Formatador.retornaValorDinheiro(pedido.getValorTotal()) %>
				</td>
				

			</tr>
		<%
			}
		%>
		</table>
		
		<a href="index.jsp" >Página inicial</a>
		
	</body>
</html>