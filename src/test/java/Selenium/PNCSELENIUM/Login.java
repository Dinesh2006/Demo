package Selenium.PNCSELENIUM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Webdriver;



public class Login {

	private WebDriver driver;
	@Test (dataProvider="usernameandpassword", description="Test Data", priority=2)
	public void login1() {
		driver.findElement(By.linkText("sign-in")).click();
		driver.findElement(By.name("userName")).sendKeys("Sambit");
		driver.findElement(By.name("password")).sendKeys("asd");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals("Find a Flight", driver.getTitle());
	}


	@DataProvider(name="usernameandpassword")
	public String[][] credentials()  {
		return new String[][] {
			new String[] {"invalidUN","invalidPW"},
			new String[] {"username1","password1"},
		};
	}
	
	
	
	@Test(priority=1)
	public void register()
	{
		//Register************************************************************************	
		driver.findElement(By.xpath("//a[contains(text(), 'REGISTER')]")).click();
		driver.findElement(By.name("firstName")).sendKeys("Dinesh");
		driver.findElement(By.name("lastName")).sendKeys("Hinduja");
		driver.findElement(By.name("phone")).sendKeys("9669071655");
		driver.findElement(By.id("userName")).sendKeys("dineshhinduja@accenture.com");
		driver.findElement(By.name("address1")).sendKeys("Bhosale Garden");
		driver.findElement(By.name("city")).sendKeys("Pune");
		driver.findElement(By.name("state")).sendKeys("Maharastra");
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("Dinesh");
		driver.findElement(By.name("password")).sendKeys("Hinduja");
		driver.findElement(By.name("confirmPassword")).sendKeys("Hinduja");
		driver.findElement(By.xpath("//input[@src='/images/forms/submit.gif']")).click();
		//WebElement  name=	driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b"));
		//String textValue = name.getText();
		//Assert.assertEquals("Dear",textValue.startsWith("Dear"));
	}

	@BeforeTest
	public void beforeTest() {
		driver =Webdriver.createDriver();
		driver.get("http://newtours.demoaut.com//");
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
