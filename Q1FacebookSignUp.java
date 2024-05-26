package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Q1FacebookSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");

		// verify that the website has been redirected to the facebook home page
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		if (expectedTitle.contentEquals(actualTitle)) {
			System.out.println("Page title verification passed. Facebook home page open successfully");
		} else {
			System.out.println("Page title verification failed, Current title is " + actualTitle);
		}

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("testuser@test.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("testuser@test.com");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Test@123");

		WebElement dateSelect = driver.findElement(By.xpath("//select[@id='day']"));
		Select dSelect = new Select(dateSelect);
		dSelect.selectByIndex(10);
		WebElement monthSelect = driver.findElement(By.xpath("//select[@id='month']"));
		Select mSelect = new Select(monthSelect);
		mSelect.selectByValue("5");
		WebElement yearSelect = driver.findElement(By.xpath("//select[@id='year']"));
		Select ySelect = new Select(yearSelect);
		ySelect.selectByVisibleText("1985");

		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

		// verify that the user is successfully register on facebook and redirected to
		// the facebook home page
		String expectedText = "Facebook";
		String actualText = driver.getTitle();
		if (expectedText.contentEquals(actualText)) {
			System.out.println("Successfully Login to facebook");
		} else {
			System.out.println("Sign Up failed");
		}
		driver.quit();
	}

}

Output:
May 26, 2024 6:37:36 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
Page title verification passed. Facebook home page open successfully
Sign Up failed

