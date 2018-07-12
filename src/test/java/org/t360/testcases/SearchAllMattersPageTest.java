package org.t360.testcases;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.SearchAllMattersPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class SearchAllMattersPageTest extends Controller{

	LoginPage loginpage;
	HomePage homepage;
	SearchAllMattersPage searchallmatterspage;
	@BeforeMethod
	public void prepareTest()
	{
		initialize();
		loginpage=new LoginPage();
		homepage=loginpage.login("System Administrator");
		homepage=homepage.selectNetwork("Matter Management Regression Network");
		searchallmatterspage=homepage.navigateToSearchAllMattersPage();
	}
	
	@Test(priority=1, description="TestCase ID:4441")
	public void validateSearchAllMattersPageTest(){
		
		Assert.assertTrue(searchallmatterspage.validateSearchAllMattersPage());
		
	}
	
	@Test(priority=2, description="TestCase ID:4442")
	public void validateSearchAndSelectMatterTest()
	{
		searchallmatterspage.SearchAndSelectMatter("inv_tempmatter");
	}
	
	@AfterMethod
	public void terminateTest()
	{
		driver.close();
	}
	
}
