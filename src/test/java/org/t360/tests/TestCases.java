package org.t360.tests;



import org.t360.controller.Controller;
import org.t360.pages.AddTeamMembersPage;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.MatterCreationWorkflowPage;
import org.t360.pages.MatterPropertiesPage;
import org.t360.pages.SearchAllMattersPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends Controller{
	
	String user="System Administrator";
	String network="Temp Network KT";
	String matter_name="temp matter14";
	String workarea="Temp Network KT";
	String matter_start_date="7/9/2018";
	String member_name;
	
	
	@BeforeMethod
	public void prepareTest()
	{
		initialize();
	}
	
/*	@AfterMethod
	public void terminateTest()
	{
		driver.close();
	}*/
	@Test(priority=1,description="TestCase ID:0001")
	public void createMatterTest(){
		
		LoginPage loginpage=new LoginPage();
		HomePage homepage=loginpage.login(user);
		homepage=homepage.selectNetwork(network);
		MatterCreationWorkflowPage mattercreationworkflowpage=homepage.navigateToMatterCreationWorkflowPage(homepage);
		MatterPropertiesPage matterpropertiespage=mattercreationworkflowpage.addMatter(matter_name,workarea,matter_start_date ,"Open", mattercreationworkflowpage);
		Assert.assertTrue(matterpropertiespage.validateMatterName(matter_name));
	}
	
	@Test(priority=2,description="TestCase ID:0001")
	public void addMemberToMatter()
	{	
		member_name="comp1";
		initialize();
		LoginPage loginpage=new LoginPage();
		HomePage homepage=loginpage.login(user);
		homepage=homepage.selectNetwork(network);
		SearchAllMattersPage searchallmatterspage=homepage.navigateToSearchAllMattersPage();
		MatterPropertiesPage matterpropertiespage=searchallmatterspage.SearchAndSelectMatter(matter_name);
		AddTeamMembersPage addteammemberspage=matterpropertiespage.clickOnAddTeamMember();
		matterpropertiespage=addteammemberspage.searchAndSelectMember(member_name, addteammemberspage);
		
	}
	

	
}
