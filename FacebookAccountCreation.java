package assignments.week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAccountCreation {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Krishnan");
		driver.findElement(By.name("lastname")).sendKeys("Kankipati");
		driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile number')]")).sendKeys("8939226606");
		driver.findElement(By.xpath("(//input[contains(@aria-label,'Mobile number')]/following::input)[2]")).sendKeys("Barcelona7");
		WebElement birthDate=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select birth = new Select(birthDate);
		birth.selectByIndex(8);
		Select birthMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		birthMonth.selectByVisibleText("Jul");
		Select birthYear = new Select(driver.findElement(By.id("year")));
		birthYear.selectByValue("1983");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		boolean radioButtonSelection=driver.findElement(By.xpath("//input[@type='radio']")).isSelected();
		System.out.println(radioButtonSelection);
	}
}