package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Webdriver {

	public static WebDriver createDriver() {
		String webdriver = System.getProperty("Browser","ie");

		switch(webdriver)  {

			case "Firefox":
				System.setProperty("webdriver.gecko.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Driver Selenium\\geckodriver.exe");
               return new FirefoxDriver();
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Driver Selenium\\chromedriver.exe");
			return new ChromeDriver();
		case "ie":
			System.setProperty("webdriver.ie.driver","C:\\Users\\pdc4-training.pdc4\\Desktop\\Driver Selenium\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;


	}
}
