package reddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
/*
 * Verify Footer links
 * Verify text in the webpage
 * 
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFooter_text {
	WebDriver driver;

	@Test
	public void Axelos_Certification() {
		System.setProperty("webdriver.firefox.marionette",
				"E:\\SeleniumSetup\\geckodriver-v0.9.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.axelos.com/certifications");
		// TestCase: to identify the desired text on the page,print it, get the
		// length of the string to find how much you want to print. Then using
		// that value and substring functionality you can define the text that
		// should be printed.
		/*
		 * String para =
		 * driver.findElement(By.xpath("//h1/following-sibling::div/p")).getText
		 * (); System.out.println(para);
		 * System.out.println("___________________"); String st =
		 * "AXELOS’ certifications are globally recognized and highly sought after by potential employers. They can help you to quickly improve your skills and capabilities across a number of key business disciplines, in turn driving strong business performance."
		 * ; System.out.println(st.length());
		 * System.out.println(para.substring(0,100)
		 * +" : till 100th character in the para");
		 * System.out.println(para.substring(0,
		 * 250)+" : till 250th character in the para");
		 */

		// This is the expected text, which we have to verify the expected text
		// is present or not in the webpage.
		String expected_para = "AXELOS’ certifications are globally recognized and highly sought after by potential employers. They can help you to quickly improve your skills and capabilities across a number of key business disciplines, in turn driving strong business performance.";
		String para1 = driver.findElement(By.xpath("//h1/following-sibling::div/p")).getText().substring(0, 250);
		System.out.println(para1);
		Assert.assertEquals(para1, expected_para);
		// Testcase: Verify Page title is as expected.
		// get the page title into a string
		String titleoriginal = driver.getTitle();
		// expected title
		String titleexpected = "Certifications | ITIL, PRINCE2, MSP, RESILIA | AXELOS";
		Assert.assertEquals(titleoriginal, titleexpected, "Text is not same ..");

		// TestCase : Verify Footer links
		// print footer links text
		String all = driver.findElement(By.xpath(".//*[@id='footer']/div/ul[1]/li/a")).getText();
		System.out.println("All Footer links : " + all);
		// declared expeced array with footer link text.
		List<String> exp_list = Arrays.asList("FAQs", "Contact", "Policies", "Licensing", "Legal", "Privacy", "Cookies",
				"Accessibility", "Best Practice Feedback");
		List<String> list = new ArrayList<String>();
		// get the footer links size
		int footer_links_size = driver.findElements(By.xpath(".//*[@id='footer']/div/ul[1]/li")).size();
		for (int f = 1; f <= footer_links_size; f++) {
			// get the link name
			String link_name = driver.findElement(By.xpath(".//*[@id='footer']/div/ul[1]/li[" + f + "]/a")).getText();
			// get the link url
			// String link_url =
			// driver.findElement(By.xpath(".//*[@id='footer']/div/ul[1]/li[" +
			// f + "]/a"))
			// .getAttribute("href");
			// print link text and url
			// System.out.println(link_name + " : " + link_url);
			list.add(link_name);

		}
Assert.assertEquals(list, exp_list);
		System.out.println(list.toString());
	}
}
