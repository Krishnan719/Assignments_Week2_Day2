package assignments.week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class EditLead {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.edge.driver", "C:\\Users\\284035\\OneDrive - Cognizant\\Documents\\Automation\\AutomationAllApps\\src\\main\\resources\\browserDrivers\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.className("inputLogin")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[@name='firstName'])[3]")).sendKeys("Hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Thread.sleep(4000);
		if(driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM")){
			System.out.println("Title is matching");
		}
		else {
			System.out.println("Title is not getting matched");
		}
		String beforeEdit=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(beforeEdit);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeafSolutions");
		String changedValue=driver.findElement(By.id("updateLeadForm_companyName")).getAttribute("value");
		System.out.println(changedValue);
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(4000);
		String afterEdit=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(afterEdit);
		String regEX=afterEdit.replaceAll("[\\W\\d]","");
		System.out.println(regEX);
		if(changedValue.equalsIgnoreCase(regEX)){
			System.out.println("Able to see the updated company name");
		}
		else {
			System.out.println("Not able to see the updated company name");
		}
		driver.close();
	}
}