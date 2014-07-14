<html>
	<head>
		<title>Fechar pedido</title>
		<script type="text/javascript">  
		    function changeVisibility(value)
		    {  
		        if (value == "dinhtrc")  
		            document.getElementById("troco").style.display='block';
		        else
		        	document.getElementById("troco").style.display='none';
		    }
		</script>  
	</head>
	<body>
		<form method="post"	action="FechaPedido">
			Forma de pagamento:<br> 
			<select name = "formaPagamento" onchange="changeVisibility(this.value)">
		        <option value ="credito">Cartão de Crédito</option>
		        <option value ="debito">Cartão de Débito</option>
		        <option value ="dinheiro">Dinheiro</option>
		        <option value ="dinhtrc">Dinheiro com troco</option>
		    </select>  
			<br>
			<div id="troco" style="display:none">Entre com o troco:<br>
				<input type="text" name="troco"/><br>
			</div>
			<input type="submit" value="Fechar pedido">
		</form>
	</body>
</html>