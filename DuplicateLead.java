package assignments.week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\TestLeaf_January_2022_Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		String text="No records to display";
		if(text.equalsIgnoreCase("No records to display")) {
			System.out.println("User message displayed");
		}
		else {
			System.out.println("User message not displayed");
		}
		String number=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(number);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		Thread.sleep(4000);
		String afterSelection=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(afterSelection);
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String title="Duplicate Lead | opentaps CRM";
		if(title.equalsIgnoreCase("Duplicate Lead | opentaps CRM")) {
			System.out.println("Title is matching");
		}
		else {
			System.out.println("Title is not matching");
		}
		String beforeSelection=driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).getAttribute("value");
		System.out.println(beforeSelection);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		if(afterSelection.equals(beforeSelection)) {
			System.out.println("Duplicated lead name is same as captured name");
		}
		else {
			System.out.println("Duplicated lead name is not same as captured name");
		}
		//driver.close();
	}
}