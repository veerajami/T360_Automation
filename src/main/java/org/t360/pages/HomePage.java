package org.t360.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;
import org.t360.util.Utility;

public class HomePage extends Controller {
	
	
	@FindBy(xpath="//div/h1[contains(text(),'Home Page')]")
	WebElement homePage_text;
	
	@FindBy(xpath="//a[text()='Main Menu']")
	WebElement mainMenu_link;
	
	@FindBy(xpath="//a[text()='Search All Matters']")
	WebElement searchAllMatters_link;
	
	@FindBy(xpath="//a[text()='Search All Invoices']")
	WebElement searchAllInvoices_link;
	
	@FindBy(xpath="//ul[@class='header-links']/li[@id='networkHeaderId']")
	WebElement networks_dropdown;
	
	@FindBy(xpath="//ul[@class='header-links']/li[@id='userHeaderId']")
	WebElement userProfile_dropdown;
	
	@FindBy(xpath="//ul[@class='header-links']/li[@id='globalSearchHeaderId']")
	WebElement search_dropdown;
	
	@FindBy(xpath="//li/span[text()='Log Off']")
	WebElement logOff_button;
	
	@FindBy(xpath="//a[text()='Add Matter']")
	WebElement addMatters_link;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHomePage(){
		driver.switchTo().frame(2);
		return homePage_text.isDisplayed();
	}
	
	public boolean validateUser(String user){
		driver.switchTo().frame(2);
		return homePage_text.getText().contains(user);
	}
	
	public HomePage selectNetwork(String name){
		
		if(getCurrentNetwork().contains(name))
			return new HomePage();
		else{
		networks_dropdown.click();
		WebElement netowork_link=Utility.synchronizeAndFindElement("//a[text()='"+name+"']", driver);
		Utility.scrollAndClick(netowork_link);	
		Utility.synchronizeAndFindElement("//div/h1[contains(text(),'Home Page')]", driver);
		return new HomePage();
		}
		}
		
	public HomePage clickOnMainMenu(){
		mainMenu_link.click();
		
		return new HomePage();
		
	}
	
	
	public MatterCreationWorkflowPage navigateToMatterCreationWorkflowPage(HomePage homepage){
		homepage=clickOnMainMenu();
		
		addMatters_link.click();
		

		
		return new MatterCreationWorkflowPage();
		
	}
	
   public SearchAllMattersPage navigateToSearchAllMattersPage()
   {
	   searchAllMatters_link.click();
	   
	   return new SearchAllMattersPage();
   }
	public String getCurrentNetwork(){
		
		return networks_dropdown.getText();
	}
	
}
