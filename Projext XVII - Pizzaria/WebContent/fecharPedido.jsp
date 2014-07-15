<html>
	<head>
		<title>Fechar pedido</title>
		<script type="text/javascript">  
		    function changeVisibility(value)
		    {  
		        if (value == "DINHTRC")  
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
		        <option value ="CREDITO">Cartão de Crédito</option>
		        <option value ="DEBITO">Cartão de Débito</option>
		        <option value ="DINHEIRO">Dinheiro</option>
		        <option value ="DINHTRC">Dinheiro com troco</option>
		    </select>  
			<br>
			<div id="troco" style="display:none">Entre com o troco:<br>
				<input type="text" name="troco"/><br>
			</div>
			<input type="submit" value="Fechar pedido">
		</form>
	</body>
</html>