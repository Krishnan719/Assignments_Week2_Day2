package javalearning.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class DropDownExample {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement firstDropDown=driver.findElement(By.xpath("//option[contains(text(),'Index')]/ancestor::select"));
		Select firstByIndex = new Select(firstDropDown);
		firstByIndex.selectByIndex(2);
		WebElement secondDropDown=driver.findElement(By.xpath("//option[contains(text(),'Text')]/ancestor::select"));
		Select secondByText = new Select(secondDropDown);
		secondByText.selectByVisibleText("Selenium");
		WebElement thirdDropDown=driver.findElement(By.xpath("//option[contains(text(),'Value')]/ancestor::select"));
		Select thirdByValue = new Select(thirdDropDown);
		thirdByValue.selectByValue("4");
		WebElement total=driver.findElement(By.xpath("//option[contains(text(),'options')]/ancestor::select"));
		Select overall = new Select(total);
		List<WebElement> values=overall.getOptions();
		int overallCount=values.size();
		System.out.println(overallCount);
		driver.findElement(By.xpath("//option[contains(text(),'select')]/ancestor::select")).sendKeys("SE");
		WebElement normalSelect=driver.findElement(By.xpath("//option[contains(text(),'programs')]//ancestor::select"));
		Select fifthDropDown = new Select(normalSelect);
		fifthDropDown.selectByIndex(1);
	}
}