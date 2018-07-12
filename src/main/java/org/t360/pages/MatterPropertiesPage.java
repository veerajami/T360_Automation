package org.t360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;

public class MatterPropertiesPage extends Controller{

	@FindBy(xpath="//span[contains(text(),'Matter:')]")
	WebElement matter_text;
	
	@FindBy(xpath="//td[label[text()='Matter Name:']]//following-sibling::td/span")
	WebElement mattername_text;
	
	@FindBy(xpath="//td[label[text()='Open Date:']]//following-sibling::td/span")
	WebElement opendate_text;
	
	@FindBy(xpath="//td[label[text()='Work Area:']]//following-sibling::td/span/a[2]")
	WebElement workarea_link;
	
	@FindBy(xpath="//td[label[text()='Matter Number:']]//following-sibling::td/span")
	WebElement matternumber_text;
	
	@FindBy(xpath="//td[text()='Add']")
	WebElement add_link;
	
	@FindBy(xpath="//p[text()='Add Team Member']")
	WebElement addTeamMember_option;
	
	public MatterPropertiesPage(){
		PageFactory.initElements(driver, this);
	}
	

	
	public boolean validateMatterPropertiesPage(){

		driver.switchTo().frame(2);
		boolean result=matter_text.isDisplayed();
		driver.switchTo().defaultContent();
		return result;
	}
	
	public boolean validateMatterName(String matter_name){
		
			driver.switchTo().frame(2);
			driver.switchTo().frame(0);
			if(mattername_text.getAttribute("innerText").contains(matter_name))
			{
				driver.switchTo().defaultContent();
				return true;
			}
			else {
				driver.switchTo().defaultContent();
				return false;
			}
			
		}

	public boolean validateMatterOpenDate(String date){
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		if(opendate_text.getAttribute("innerText").equals(date))
		{
			driver.switchTo().defaultContent();
			return true;
		}
		else {
			driver.switchTo().defaultContent();
			return false;
		}
	
}
	public boolean validateMatterWorkArea(String workarea){
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		if(workarea_link.getAttribute("innerText").equals(workarea))
		{
			driver.switchTo().defaultContent();
			return true;
		}
		else {
			driver.switchTo().defaultContent();
			return false;
		}
	
}
	public int getMatternumber(){
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		int matter_number=Integer.parseInt(matternumber_text.getAttribute("innerText"));
		driver.switchTo().defaultContent();
		return matter_number;
	
	}
	  
	public void clickOnAddLink(){
		
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		add_link.click();
		
		
	}
	
	public AddTeamMembersPage clickOnAddTeamMember()
	{
		clickOnAddLink();
		addTeamMember_option.click();
		driver.switchTo().defaultContent();
		return new AddTeamMembersPage();
	}
}