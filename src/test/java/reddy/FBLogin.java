package reddy;

/*
 * Get all the Link text and Link URL from FB Login Page.
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FBLogin {
	WebDriver driver;

	@Test
	public void testLogin() {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		// open login page url
		driver.get("https://www.facebook.com/");

		// get the word(string) from page and print in console
		String word = driver.findElement(By.xpath("//label[@for='email']")).getText();
		System.out.println("sample word : " + word);
		// print length of the word.
		System.out.println("length : " + word.length());
		// get the attribute from a word (string)
		String word2 = driver.findElement(By.xpath("//label[contains(text(),'Email or Phone')]")).getAttribute("for");
		System.out.println("sample word attribute: " + word2);

		// get the all links size in the Facebook Login page.
		List<WebElement> tagnames = driver.findElements(By.tagName("a"));
		int i = tagnames.size();
		// print all links count
		System.out.println("List " + i);
		// Print all links text from the FB Login page.
		for (int j = 0; j < i; j++) {
			// Print Link text and Link URL
			System.out.println(j + ")." + tagnames.get(j).getText() + "=> " + tagnames.get(j).getAttribute("href"));
		}
		// Find the repeated word count from Facebook Login page.
		int k = driver.findElements(By.xpath("//div[@class='_li']/..//*[contains(text(), 'Face')]")).size();
		System.out.println("Face Size : " + k);

	}

}
