package org.t360.testcases;

import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.util.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends Controller{
	
	LoginPage loginpage;
	HomePage homepage;
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void prepareTest(){
		
		initialize();
		loginpage=new LoginPage();
		
	}
	
	@AfterMethod()
	public void terminateTest()
	{
		driver.close();
	}
	
	
	@Test(priority=1, description="TestCase ID:1111")
	public void validateLoginPageTest(){
		Assert.assertTrue(loginpage.validateLoginPage());
	}
	
	@Test(priority=2, description="TestCase ID:1112")
	public void loginTest(){
		homepage=loginpage.login("System Administrator");
		Assert.assertTrue(homepage.validateUser("System Administratorr"));
	}
	
	
	@Test(priority=3, groups="Application Functionality", dataProvider="testData", description="TestCase ID:1113")
	public void loginWithTestDataTest(String username, String password, String result)
	{	
		homepage=loginpage.login(username, password);
	    boolean status=Utility.getInputResult(result);
		Assert.assertTrue(status==(homepage!=null));
		
	}
	
	
	@DataProvider
	public Object[][] testData(){
		
		return new Utility().getTestData("LoginPageData");
		
	}
	
}
