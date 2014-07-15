<%@page import="br.com.pizzariadomanolo.util.Validator"%>
<%@page import="br.com.pizzariadomanolo.util.FormaPagamento"%>
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
			<th>Detalhes</th>
		</tr>
		
		<%
			for (Pedido pedido : pedidos) {
		%>
			<tr>
				<td> <%= pedido.getData() %> </td>
				<td> <%= Validator.retornaValor(pedido.getFormaPagamento()) %> </td>
				<td> R$ <%= pedido.getTroco() %> </td>
				<td> <a onclick="">Detalhes</a></td>
				
				

			</tr>
		<%
			}
		%>
		</table>
		
	</body>
</html>