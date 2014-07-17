package interfaceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroTestInterface {
	
	@Test
	public void entrarCadastro(){
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/pizzariadomanolo/index.jsp");
		
		driver.findElement(By.linkText("Cadastro")).click();
				
		String inicial = driver.findElement(By.linkText("Página inicial")).getText();
		
		assertEquals("Página inicial",inicial);
		
		
	}

}
