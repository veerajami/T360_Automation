package org.t360.testcases;

import org.junit.Assert;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.MatterPropertiesPage;
import org.t360.pages.SearchAllMattersPage;
import org.t360.util.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatterPropertiesPageTest extends Controller{
	
	LoginPage loginpage;
	HomePage homepage;
	SearchAllMattersPage searchallmatterspage;
	MatterPropertiesPage matterpropertiespage;
	@BeforeMethod
	public void prepareTest()
	{
		initialize();
		loginpage=new LoginPage();
		homepage=loginpage.login("System Administrator");
		homepage=homepage.selectNetwork("Matter Management Regression Network");
		searchallmatterspage=homepage.navigateToSearchAllMattersPage();
		matterpropertiespage=searchallmatterspage.SearchAndSelectMatter("inv_tempmatter");
	}
	
	@Test(priority=1, description="TestCase ID:55551")
	public void validateMatterPropertiesPageTest(){
		Assert.assertTrue(matterpropertiespage.validateMatterPropertiesPage());
	}
	
	@Test(priority=2, description="TestCase ID:55552")
	public void validateMatterTest()
	{	
		
		Assert.assertTrue(matterpropertiespage.validateMatterName("inv_tempmatter"));
	}
	
	
/*	@Test(priority=3, groups="Application Functionality", dataProvider="testData", description="TestCase ID:1113")
	public void validateAddMatterWithData(String matter_name, String workarea,String date, String result)
	{	
		homepage=loginpage.login(username, password);
	    boolean status=Utility.getInputResult(result);
		Assert.assertTrue(status==homepage.validateHomePage());
		
	}
	
	
	@DataProvider
	public Object[][] testData(){
		
		return new Utility().getTestData("MatterCretationWorkflowPage ");
		
	}
	
	
	*/
	
}
