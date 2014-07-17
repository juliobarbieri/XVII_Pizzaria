package interfaceTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilTest.PopulaBanco;

public class LoginTestInterface {
	
	private String cliente ="123456";	
	private PopulaBanco popu = new PopulaBanco();	
	
	@Test
	public void logando(){
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost/pizzariadomanolo/login.jsp");
		
		WebElement form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("telefone"))).sendKeys(cliente);
		driver.findElement(By.name("senha")).sendKeys("123");
		
		form.submit();
		
		String logout = driver.findElement(By.linkText("Logout")).getText();
		
		assertEquals("Logout",logout);
		
		
	}
	
	@Before
	public void popularBanco(){
		popu.inserir();		
	}
	
	@After
	public void deletarInsercao(){
		popu.remover();		
	}

}
