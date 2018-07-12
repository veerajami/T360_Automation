package selenium.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.MatterCreationWorkflowPage;
import org.t360.util.Utility;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MatterCreation extends Controller{

	LoginPage loginpage;
	HomePage homepage;
	MatterCreationWorkflowPage mattercreationworkflowPage;
	@BeforeTest
	public void start()
	{
		initialize();
		 loginpage=new LoginPage();
		 homepage=loginpage.login("System Administrator");	
	}
	
	@Test
	public void creatMatter()
	{
		homepage.navigateToMatterCreationWorkflowPage(homepage);
		
		driver.switchTo().frame(2);
		Utility.synchronizeAndFindElement("//input[@name='MatterNameTextBox']", driver).sendKeys("temp Matter");;
		driver.findElement(By.xpath("//input[@name='WorkareaPopupTreeControl:PopupButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	System.out.println(driver.findElement(By.xpath("//td[text()='Work Area Tree']")).getText());
	driver.switchTo().frame(3);
	driver.findElement(By.xpath("//input[@name='SearchForTextBox']")).sendKeys("temp");
	
		
	}
	
	
	
	
	
	
	
}
