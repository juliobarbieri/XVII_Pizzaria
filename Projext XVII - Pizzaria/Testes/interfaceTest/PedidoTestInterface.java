package interfaceTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilTest.PopulaBanco;

public class PedidoTestInterface {
	String cliente ="123456";
	PopulaBanco popu = new PopulaBanco();
	
	@Before
	public void popularBanco(){
		popu.inserir();		
	}
	
	@Test
	public void cadastrarPedido(){
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/pizzariadomanolo/login.jsp");
		
		WebElement form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("telefone"))).sendKeys(cliente);
		driver.findElement(By.name("senha")).sendKeys("123");
		
		form.submit();
		
		driver.findElement(By.linkText("Pedido")).click();
		
		String linkPizza = driver.findElement(By.linkText("Adicionar Pizzas")).getText();
		
		assertEquals("Adicionar Pizzas",linkPizza);
		
		driver.navigate().to("http://localhost:8080/pizzariadomanolo/Redirect?page=addPizza.jsp");
		
		form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("quantidade"))).sendKeys("1");
		
		form.submit();
		
		driver.navigate().to("http://localhost:8080/pizzariadomanolo/Redirect?page=fecharPedido.jsp");
		

		form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("formaPagamento"))).sendKeys("CREDITO");
		
		form.submit();
		
		String linkLogout = driver.findElement(By.linkText("Logout")).getText();
		assertEquals("Logout", linkLogout);

		
	}
	
	@After
	public void deletarInsercao(){
		popu.remover();		
	}


}
