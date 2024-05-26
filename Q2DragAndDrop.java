package task18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class Q2DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		WebElement sourceElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement targetElement = driver.findElement(By.xpath("//p[text()='Drop here']"));

		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();

		WebElement background = driver.findElement(By.xpath("//div[@id='droppable']"));
		String backgroundColor = background.getCssValue("background");
		// System.out.println(backgroundColor);
		String s = backgroundColor.substring(0, 18);
		Color color = Color.fromString(s);
		String targetColor = color.asHex();
		String expectedColor = "#fffa90";

		if (expectedColor.contentEquals(targetColor)) {
			System.out.println("Drag and Drop Operation Successfull");
		} else {
			System.out.println("Drag and Drop Not Successfull");
		}

		String targetText = targetElement.getText();
		if (targetText.equals("Dropped!")) {
			System.out.println("Verified after drag and drop, text of target is changed to " + "'" + targetText + "'");
		} else {
			System.out.println("Drag and Drop Not Successfull");
		}
		driver.quit();
	}

}

Output:
May 26, 2024 6:41:30 PM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
Drag and Drop Operation Successfull
Verified after drag and drop, text of target is changed to 'Dropped!'
