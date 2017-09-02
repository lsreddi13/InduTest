package reddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

/* 
 * Indu usecase.
 */
public class Indutest1 {
	WebDriver driver;

	/*@Test
	public void test123() throws FindFailed {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.axelos.com/news/blogs");
		String abc = driver.findElement(By.xpath("// *[@id='corp-main']//div[@class='clearfix']/a")).getText();
		System.out.println(abc);
		driver.findElement(By.xpath("// *[@id='corp-main']//div[@class='clearfix']/a")).click();
		System.out.println(driver.getTitle());
		

	}*/
	@Test
	public void test123() throws FindFailed {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// open the page
		driver.get("https://www.axelos.com/");
		// click link text
		if(driver.findElement(By.linkText("View all news")).isDisplayed() ){
		driver.findElement(By.linkText("View all news")).click();
		System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
		}else{
			System.out.println("System not found link text");
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("View all news"))));
		driver.findElement(By.linkText("View all news")).click();
		System.out.println(driver.getCurrentUrl()+" : "+driver.getTitle());
	}
	

	
	
	
}