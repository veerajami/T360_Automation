package org.t360.testcases;

import org.junit.Assert;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.MatterCreationWorkflowPage;
import org.t360.pages.MatterPropertiesPage;
import org.t360.util.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MatterCreationWorkflowPageTest extends Controller {
	
	LoginPage loginpage;
	HomePage homepage;
	MatterCreationWorkflowPage mattercreationworkflowPage;
	MatterPropertiesPage matterpropertiespage;
	
	@BeforeMethod
	public void prepareTest() {
	 initialize();
	 loginpage=new LoginPage();
	 homepage=loginpage.login("System Administrator");
	 homepage=homepage.selectNetwork("Temp Network KT");
	 mattercreationworkflowPage=homepage.navigateToMatterCreationWorkflowPage(homepage);
	}

	@AfterMethod
	public void terminateTest(){
		driver.close();
	}
	
	@Test(priority=1, description="TestCase ID:3331")
	public void validateMatterCreationWorkflowPageTest()
	{
		Assert.assertTrue(mattercreationworkflowPage.validateMatterCreationWorkflowPage());
	}
	
	@Test(priority=2, description="TestCase ID:3332")
	public void addMatterTest(){
		matterpropertiespage=mattercreationworkflowPage.addMatter("temp matter13", "Temp Network KT", "7/4/2018", "Open", mattercreationworkflowPage);
		SoftAssert assertion=new SoftAssert();
		
		assertion.assertTrue(matterpropertiespage.validateMatterPropertiesPage());
		assertion.assertTrue(matterpropertiespage.validateMatterName("temp matter2"));
		assertion.assertTrue(matterpropertiespage.validateMatterOpenDate("7/4/2018"));
		assertion.assertTrue(matterpropertiespage.validateMatterWorkArea("Temp Network KT"));
		
		assertion.assertAll();
			
	}
	
	
	
	@Test(priority=3, groups="Application Functionality", dataProvider="testData", description="TestCase ID:3333")
	public void validateCreateMatterWithDataTest(String matter_name, String workarea, String matter_start_date ,String status,String result, String existance, String comments)
	{	
		matterpropertiespage=mattercreationworkflowPage.addMatter(matter_name, workarea, matter_start_date, status, mattercreationworkflowPage);
		SoftAssert assertion=new SoftAssert();
		
		assertion.assertTrue(matterpropertiespage.validateMatterPropertiesPage());
		assertion.assertTrue(matterpropertiespage.validateMatterName(matter_name));
		assertion.assertTrue(matterpropertiespage.validateMatterOpenDate(matter_start_date));
		assertion.assertTrue(matterpropertiespage.validateMatterWorkArea(workarea));
		
		assertion.assertAll();
		
	}
	
	
	@DataProvider
	public Object[][] testData(){
		
		return new Utility().getTestData("MatterCretationWorkflowPage");
		
	}
	
	
	
	
}
