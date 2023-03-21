package Learnings.org.liveProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Verification {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\HP\\eclipse-workspace\\SeleniumConfig\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// Goto http://live.techpanda.org/
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Verify Title of the page
		String title = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(title);

		// Click on ‘MOBILE’ menu
		driver.findElement(By.linkText("MOBILE")).click();

		// In the list of all mobile read the cost of SonyXperia
		String pp = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();

		// Click on SonyXperia mobile
		driver.findElement(By.id("product-collection-image-1")).click();

		// Read the XPeria mobile price from details page
		String dp = driver.findElement(By.cssSelector("span.price")).getText();

		// close Window
		driver.quit();
	}
}
