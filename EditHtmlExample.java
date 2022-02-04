package javalearning.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditHtmlExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("krishnank8@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("Addition");
		String text=driver.findElement(By.xpath("//input[@name='username']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//label[contains(text(),'Clear the')]/following::input")).clear();
		WebElement verification=driver.findElement(By.xpath("//label[contains(text(),'Confirm that edit')]/following::input"));
		if(verification.isEnabled()) {
			System.out.println("Verified the text field is disabled");
		}
		else {
			System.out.println("Verified the text field is not enabled");
		}
	}
}