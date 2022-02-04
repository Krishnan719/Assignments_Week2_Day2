package javalearning.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

public class ButtonHtmlExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		String title=driver.getTitle();
		System.out.println(title);
		driver.navigate().back();
		Point position=driver.findElement(By.id("position")).getLocation();
		System.out.println(position);
		String color=driver.findElement(By.id("color")).getAttribute("style");
		System.out.println(color);
		String sizeColor=driver.findElement(By.xpath("//button[contains(text(),'What is')]")).getAttribute("style");
		System.out.println(sizeColor);
		Dimension size=driver.findElement(By.xpath("//button[contains(text(),'What is')]")).getSize();
		System.out.println(size.getHeight());
		System.out.println(size.getWidth());
		int heightValue=size.height;
		System.out.println(heightValue);
		int widthValue=size.width;
		System.out.println(widthValue);
	}
}
