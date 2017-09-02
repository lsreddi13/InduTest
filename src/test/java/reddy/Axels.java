package reddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Axels {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void testCountries() throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.axelos.com/");
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='field-group form-area']/div/div[contains(text(),'Select a country')]"));
		if(dropdown.isDisplayed()){
			driver.findElement(By.xpath("//div[@class='field-group form-area']/div/div[contains(text(),'Select a country')]")).click();
			
			int s = driver.findElements(By.xpath("//select[@class='partnerSearchCountry searchbox']/..//ul/li")).size();
			System.out.println(s);
			for(int i=1; i<=s; i++){
				System.out.println(i+"."+driver.findElement(By.xpath("//select[@class='partnerSearchCountry searchbox']/..//ul/li["+i+"]")).getText());
			}
		}
		
		
		driver.quit();
	}
}
