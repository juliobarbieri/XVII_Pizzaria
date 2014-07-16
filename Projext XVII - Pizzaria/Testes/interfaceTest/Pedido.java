package interfaceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pedido {
	
	@Test
	public void cadastrarPedido(){
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost/pizzariadomanolo/login.jsp");
		
		WebElement form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("telefone"))).sendKeys("991619583");
		driver.findElement(By.name("senha")).sendKeys("123");
		
		form.submit();
		
		driver.findElement(By.linkText("Pedido")).click();
		
		String linkPizza = driver.findElement(By.linkText("Adicionar Pizzas")).getText();
		
		assertEquals("Adicionar Pizzas",linkPizza);
		
		driver.navigate().to("http://localhost/pizzariadomanolo/Redirect?page=addPizza.jsp");
		
		form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("quantidade"))).sendKeys("1"); //foi até aqui, não consigo pegar o botão remover
		
		form.submit();
		
		driver.navigate().to("http://localhost/pizzariadomanolo/Redirect?page=pedido.jsp");
		
				
		driver.findElement(By.tagName("Remover")).submit();
		

		
	}

}
