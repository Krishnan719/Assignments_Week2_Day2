package javalearning.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class ImageHtmlExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\TestLeaf_January_2022_Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("tESTleaf - SELENIUM Playground")) {
			System.out.println("Title is matching");
		}
		else {
			System.out.println("Title is not matching");
		}
		driver.navigate().back();
		WebElement images=driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']"));
		if(images.getAttribute("naturalWidth").equals("0")) {
			System.out.println("Image is broken");
		}
		else {
			System.out.println("Image is not broken");
		}
	}
}