package org.t360.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;

public class AddTeamMembersPage extends Controller {

	@FindBy(xpath="//div[@id='MainHeaderText']")
	WebElement title_text;
	
	@FindBy(xpath="//input[@name='LastNameTextBox']")
	WebElement lastName_textbox;
	
	@FindBy(xpath="//button[@text()='Search']")
	WebElement search_button;
	
	@FindBy(xpath="//input[@name='SaveButton']")
	WebElement save_button; 
	
	
	public AddTeamMembersPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public MatterPropertiesPage searchAndSelectMember(String member_name, AddTeamMembersPage addteammemberspage)
	{
		driver.switchTo().frame(2);
		lastName_textbox.sendKeys(member_name,Keys.ENTER);
//		search_button.click();
		addteammemberspage=new AddTeamMembersPage();	
		driver.findElement(By.xpath("//tr[td[span[contains(text(),'"+member_name+"')][@id='MatterAddIndividualDataGrid__ctl3_FullNameLabel']]]/td[1]/span[1]/input")).click();
		save_button.click();
		driver.switchTo().defaultContent();
		return new MatterPropertiesPage();
	
	}
	
	public void selectMember(String member_name)
	{
		
	}
}
