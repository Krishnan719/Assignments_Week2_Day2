package javalearning.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CheckboxHtmlExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//label[contains(text(),'Select the languages')]//following-sibling::div//following::input)[2]")).click();
		WebElement confirmation=driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium')]//following::input"));
		if(confirmation.isSelected()) {
			System.out.println("Selenium check box is selected");
		}
		else {
			System.out.println("Selenium check box is not selected");
		}
		driver.findElement(By.xpath("//label[contains(text(),'Confirm Selenium')]//following::input")).click();
		driver.findElement(By.xpath("//label[contains(text(),'checkboxes ')]//preceding::label[text()='DeSelect only checked']//following::input")).click();
		driver.findElement(By.xpath("(//label[contains(text(),'checkboxes ')]//preceding::label[text()='DeSelect only checked']//following::input)[2]")).click();
		List<WebElement> checkbox=driver.findElements(By.xpath("//label[contains(text(),'checkboxes ')]//following::input"));
		for (WebElement values : checkbox) {
			values.click();
		}
	}
}