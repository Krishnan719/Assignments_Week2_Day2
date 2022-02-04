package assignments.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class DeleteLead {
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
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("(//input[contains(@name,'companyName')])[2]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[contains(@id,'createLeadForm_first')]")).sendKeys("Krishnan");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[4]")).sendKeys("Kankipati");
		driver.findElement(By.xpath("//input[contains(@class,'small')]")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8939226606");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement confirmation=driver.findElement(By.xpath("//div[contains(text(),'No records')]"));
		if (confirmation.isDisplayed()) {
			System.out.println("User message displayed");
		} else {
			System.out.println("user message not displayed");
		}
		driver.findElement(By.xpath("//span[text()='Name and ID']")).click();
		driver.findElement(By.xpath("//input[@name='id']/following::input")).sendKeys("Krishnan");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String identification=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println(identification);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(identification);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		WebElement confirmation1=driver.findElement(By.xpath("//div[contains(text(),'No records')]"));
		if (confirmation1.isDisplayed()) {
			System.out.println("User message displayed");
		} else {
			System.out.println("user message not displayed");
		}
		//driver.close();
	}
}