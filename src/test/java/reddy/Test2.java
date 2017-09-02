package reddy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// open the page
		driver.get("https://www.axelos.com/");
	}

	@Test
	public void search() throws InterruptedException {
		driver.get("https://www.axelos.com");
		System.out.println(driver.getTitle());
		//driver.findElement(By.xpath(".//*[@class='CookieText']/p[3]/a")).click();
		// driver.findElement(By.xpath(".//*[@class='view-all-news-link']/a"));
		// driver.findElement(By.xpath(".//*[@class='view-all-news-link']/a")).click();
		// using explicit wait we are asking to wait until the element is
		// clickable.

		driver.findElement(By.linkText("View all news")).click();

		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
		if (driver.findElement(By.xpath(".//*[@class='select-container']/div")).isDisplayed()) {
			driver.findElement(By.xpath(".//*[@class='select-container']/div")).click();
			Thread.sleep(6000);
			String label = driver.findElement(By.xpath(".//*[@class='select-container']/ul/li[99]")).getText();
			System.out.println(label);
			int num = driver.findElements(By.xpath(".//*[@class='select-container']/ul/li")).size();
			System.out.println(num);
			WebElement specifiedcountry = driver.findElement(By.xpath(".//*[@class='select-container']/ul/li[99]"));
			if (specifiedcountry.isDisplayed()) {
				specifiedcountry.click();
				System.out.println("Specified COuntry is UK");
			} else {
				System.out.println("Specified Language not available");
			}

			Thread.sleep(10000);
			driver.findElement(By.xpath(".//*[@id='partner-search']/div/div/div[2]/div/div")).click();
			WebElement specifiedregion = driver
					.findElement(By.xpath(".//*[@id='partner-search']/div/div/div[2]/div/ul/li[39]"));
			if (specifiedregion.isDisplayed()) {
				specifiedregion.click();
				System.out.println("Specified region is : London");
			} else {
				System.out.println("Specified region not available");
			}
			driver.findElement(By
					.xpath(".//*[@id='p_lt_ctl04_pageplaceholder_p_lt_ctl02_ctl04_SimplePartnerSearchWidget_partnerSearchFilterBtn']"))
					.click();
		} else {
			System.out.println("element not found");
		}
	}
}
