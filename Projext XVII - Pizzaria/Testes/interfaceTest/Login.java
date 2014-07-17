package interfaceTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	
	@Test
	public void logando(){
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost/pizzariadomanolo/login.jsp");
		
		WebElement form = driver.findElement(By.tagName("form"));
		
		driver.findElement(By.name(("telefone"))).sendKeys("991619583");
		driver.findElement(By.name("senha")).sendKeys("123");
		
		form.submit();
		
		String logout = driver.findElement(By.linkText("Logout")).getText();
		
		assertEquals("Logout",logout);
		
		
	}

}
