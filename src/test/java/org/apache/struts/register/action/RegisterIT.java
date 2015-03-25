package org.apache.struts.register.action;


import org.apache.struts2.StrutsTestCase;
import org.junit.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class RegisterIT extends StrutsTestCase{
	
	
	public void testHomePagePasses() throws Exception {
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.get("http://localhost:8080/struts2sample");
		
		assertTrue(driver.getTitle().startsWith("Basic"));
		
		driver.quit();

	}
	
	public void testHomePageRegisterPasses() throws Exception {
		
		final WebDriver driver = new HtmlUnitDriver();
		
		driver.get("http://localhost:8080/struts2sample");
		
		assertTrue(driver.getTitle().startsWith("Basic"));
		
		WebElement element = driver.findElement(By.name("register"));
		
		element.click();
		
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return driver.getTitle().startsWith("Register");
            }
        });


		assertTrue(driver.getTitle().startsWith("Register"));

			
		driver.quit();

	}
	
	public void testRegisterPagePasses() throws Exception {
		
		final WebDriver driver = new HtmlUnitDriver();
		
		driver.get("http://localhost:8080/struts2sample/register.jsp");
		
		assertTrue(driver.getTitle().startsWith("Register"));
		
		WebElement element = driver.findElement(By.name("personBean.firstName"));
		
		element.sendKeys("John");

		element = driver.findElement(By.name("personBean.lastName"));
		
		element.sendKeys("Doe");

		element = driver.findElement(By.name("personBean.email"));
		
		element.sendKeys("John@doe.com");

		element = driver.findElement(By.name("personBean.age"));
		
		element.sendKeys("19");
		
		element.submit();

		
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return driver.getTitle().startsWith("Registration Successful");
            }
        });


		assertTrue(driver.getTitle().startsWith("Registration Successful"));

			
		driver.quit();

	}
	
}
