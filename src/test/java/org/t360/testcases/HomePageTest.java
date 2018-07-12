package org.t360.testcases;

import org.junit.Assert;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Controller{
	
	LoginPage loginpage;
	HomePage homepage;
	String network_name;
	@BeforeMethod
	public void prepareTest(){
		initialize();
		loginpage=new LoginPage();
		homepage=loginpage.login("System Administrator");
	}
	
	@AfterMethod
	public void terminateTest(){
		driver.close();
	}

	@Test(priority=1, description="TestCase ID:2221")
	public void validateHomePageTest(){
		 
		Assert.assertTrue(homepage.validateHomePage());		
		
	}
	
	@Test(priority=2, description="TestCase ID:2222")
	public void selectNetworkTest(){
		network_name="Temp Network";
		homepage.selectNetwork(network_name);
		
		Assert.assertTrue(homepage.getCurrentNetwork().contains("Temp Network"));
	}
	
	@Test(priority=3, description="TestCase ID:2223")
	public void navigateToMatterCreationWorkFlowPage(){
		Assert.assertTrue(homepage.navigateToMatterCreationWorkflowPage(homepage).validateMatterCreationWorkflowPage());
		
		
	}
	
}
