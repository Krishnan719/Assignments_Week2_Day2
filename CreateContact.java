package assignments.week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\TestLeaf_January_2022_Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Krishnan");
		driver.findElement(By.id("lastNameField")).sendKeys("Kankipati");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Subashini");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Kankipati");
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Information Technology");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Engineering");
		driver.findElement(By.id("createContactForm_primaryPhoneNumber")).sendKeys("8939226606");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryPhoneAskForName']//following::input")).sendKeys("krishnank8@gmail.com");
		WebElement stateDropDown=driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select state = new Select(stateDropDown);
		state.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Life is important");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title=driver.getTitle();
		System.out.println(title);
	}
}