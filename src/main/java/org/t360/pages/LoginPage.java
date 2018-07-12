package org.t360.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;
import org.t360.util.Utility;

public class LoginPage extends Controller{
	
	String test_data_sheet="Login Page Data";
	@FindBy(xpath="//input[@name='LoginTextBox']")
	WebElement login_textbox;

	@FindBy(xpath="//input[@name='PasswordTextBox']")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@name='LoginButton']")
	WebElement login_button;
	
	@FindBy(xpath="//a[text()='Integrated Login']")
	WebElement integratedLogin_link;
	
	@FindBy(xpath="//div[@class='login-copyright']")
	WebElement copyright_text;
	
	@FindBy(xpath="//a[text()='Forgot Your Password?']")
	WebElement forgotPassword_link;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginPage(){
		return driver.getCurrentUrl().contains("LoginPage");
	}
	
	public HomePage login(String user){
		Utility util=new Utility();
		Object[] arr=util.getCellData("Login Users", util.getRowNum("Login Users", user));
		login((String)arr[0],(String)arr[1]);	
		return new HomePage();
	}
	
	public HomePage login(String user, String password)
	{
		login_textbox.sendKeys(user);
		password_textbox.sendKeys(password, Keys.ENTER);
		try{
			driver.switchTo().alert().accept();
			return null;
		}
		catch (Exception e)
		{
			
		}
		
		return new HomePage();

	}
	
	
	
	
	
}
