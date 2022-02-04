package assignments.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class GetTitle {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","C:\\Users\\284035\\OneDrive - Cognizant\\Documents\\Automation\\AutomationAllApps\\src\\main\\resources\\browserDrivers\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}
}