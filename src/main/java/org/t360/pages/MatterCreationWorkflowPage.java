package org.t360.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.t360.controller.Controller;
import org.t360.util.Utility;

public class MatterCreationWorkflowPage extends Controller{
	
	

	String xpath="//div[text()='Matter Creation Workflow']";
	@FindBy(xpath="//div[text()='Matter Creation Workflow']")
	WebElement matterCreationWorkflow_text;
	
	@FindBy(xpath="//tr[@class='Header']/td[text()='Matter System Fields']")
	WebElement matterSystemFields_text;
	
	@FindBy(xpath="//input[@name='MatterNameTextBox']")
	WebElement matterName_textbox;
	
	@FindBy(xpath="//input[@name='WorkareaPopupTreeControl:SelectedNodeName']")
	WebElement workArea_textbox;
	
	
	@FindBy(xpath="//input[@name='WorkareaPopupTreeControl:PopupButton']")
	WebElement workArea_popupButton;
	
	@FindBy(xpath="//select[@name='StatusDropDown']")
	WebElement Status_dropdown;

	@FindBy(xpath="//input[@value='Next']")
	WebElement next_button;
	
	@FindBy(xpath="//input[@value='Finish']")
	WebElement finish_button;
	
	@FindBy(xpath="//input[@name='MatterOpenDatePicker']")
	WebElement matterOpenDate_textbox;
	
	@FindBy(xpath="//select[@id='dfcontrol_786']")
	WebElement df_4_dropdown;
	
	MatterCreationWorkflowPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMatterCreationWorkflowPage(){
		
		driver.switchTo().frame(2);
		boolean result=matterCreationWorkflow_text.isDisplayed();
		driver.switchTo().defaultContent();
		return result;
		
	}
	
	public MatterPropertiesPage addMatter(String matter_name, String workarea, String date, String status, MatterCreationWorkflowPage mattercreationworkflowpage){
		
		driver.switchTo().frame(2);
		matterName_textbox.sendKeys(matter_name);
		workArea_popupButton.click();
		
		MatterCreationWorkflowPage.WorkAreaTreePopup workareatreepopup=mattercreationworkflowpage.new WorkAreaTreePopup();
		mattercreationworkflowpage=workareatreepopup.selectWorkArea(workarea, workareatreepopup);
		
		driver.switchTo().frame(2);
		matterOpenDate_textbox.clear();
		matterOpenDate_textbox.sendKeys(date);
		selectWithText(Status_dropdown, status);
		finish_button.click();
		driver.switchTo().defaultContent();
		return new MatterPropertiesPage();
		
		
	}
	
	public void selectWithText(WebElement element, String text){
	
		Select select=new Select(element);
		List<WebElement> elements=select.getOptions();
		for(int i=0;i<elements.size();i++)
		{
			WebElement option=elements.get(i);
			if(option.getText().contains(text))
			 select.selectByIndex(i);
			else
				continue;
		}
	}
//************************************************************ Work Area Tree Popup *************************************************************
	// Inner Class
	public class WorkAreaTreePopup{
		
		
		public WorkAreaTreePopup(){
		
			driver.switchTo().defaultContent();
			Utility.synchronizeAndFindElement("//td[text()='Work Area Tree']", driver);
			PageFactory.initElements(driver, this);
		}
		
	
		WebElement matterCreationWorkflow_text;
		
		@FindBy(xpath="/div[@class='modal in ui-draggable FramedDialog']")
		WebElement workArea_popup;
		
		@FindBy(xpath="//input[@name='SearchForTextBox']")
		WebElement searchbox;
		
		@FindBy(xpath="//button[@value='SearchPanel.searchButton']")
		WebElement search_button;
		
		public WebElement workArea_link;
		
		@FindBy(xpath="//input[@class='Button SubmitButton']")
		WebElement select_button;
		
		@FindBy(xpath="//input[@value='Cancel']")
		WebElement cancel_button;
		
		@FindBy(xpath="//input[@value='Tree View']")
		WebElement treeView_button;
		
		public MatterCreationWorkflowPage selectWorkArea(String workarea,WorkAreaTreePopup workareatreepopup){
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame(3);
			searchbox.sendKeys(workarea);
			workareatreepopup=clickOnSearchButton();
			driver.switchTo().frame(3);
			workArea_link=driver.findElement(By.xpath("//a[text()='"+workarea+"']"));
			workArea_link.click();
			select_button.click();
			driver.switchTo().defaultContent();
			return new MatterCreationWorkflowPage();
		}
		
		public WorkAreaTreePopup clickOnSearchButton(){
			
			search_button.click();
			
			return new WorkAreaTreePopup();
		}
		
		
		
	}

	
	
	
}