package interfaceTest;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Histórico {
	
	
	@Test
	public void entrarHistorico(){
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost/pizzariadomanolo/login.jsp");
		
		WebElement form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("telefone"))).sendKeys("991619583");
		driver.findElement(By.name("senha")).sendKeys("123");
		
		form.submit();
		
		driver.findElement(By.linkText("Histórico de Pedidos")).click();
				
		String inicial = driver.findElement(By.linkText("Página inicial")).getText();
		
		assertEquals("Página inicial",inicial);
		
		
	}
	

}
