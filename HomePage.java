package org.liveProject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
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

		// In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

		// Verify all products are sorted by name
		TakesScreenshot sh = (TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		System.out.println(src);

		File des = new File("E:\\selenium\\panda.png");
		FileUtils.copyFile(src, des);
		driver.quit();

	}
}
