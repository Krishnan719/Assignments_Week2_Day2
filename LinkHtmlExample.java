package assignments.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkHtmlExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Go to Home')]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='Button.html']")).click();
		String title=driver.getTitle();
		System.out.println(title);
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='error.html']")).click();
		String textMessage=driver.findElement(By.tagName("h1")).getText();
		if(textMessage.equalsIgnoreCase("HTTP Status 404 – Not Found")) {
		System.out.println(textMessage);
		}
		else {
			System.out.println("No error message displayed");
		}
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home')])[2]")).click();
		driver.navigate().back();
		int totalLinksPresent=driver.findElements(By.xpath("//a")).size();
		System.out.println(totalLinksPresent);
	}
}