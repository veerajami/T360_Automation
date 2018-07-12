package org.t360.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;

public class SearchAllMattersPage extends Controller{

	@FindBy(xpath="//div[@id='MainHeaderText']")
	WebElement searchMatters_text;
	
	@FindBy(xpath="//input[@name='txtMatterName']")
	WebElement mattername_textbox;


	@FindBy(xpath="//button[@name='MatterSearchPanel.searchButton']")
	WebElement search_button;
	
	public SearchAllMattersPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSearchAllMattersPage(){
		
		driver.switchTo().frame(2);
		if(searchMatters_text.isDisplayed())
		{
			driver.switchTo().defaultContent();
			return true;
		}
		else{
			driver.switchTo().defaultContent();
			return false;
		}
			
		
	}

	public MatterPropertiesPage SearchAndSelectMatter(String matter_name)
	{	
		driver.switchTo().frame(2);
		mattername_textbox.sendKeys(matter_name);
		search_button.click();
		
		driver.findElement(By.xpath("//a[text()='"+matter_name+"']")).click();
		
		driver.switchTo().defaultContent();
		return new MatterPropertiesPage();
	}
	
	
	
}
