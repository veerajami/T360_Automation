package org.t360.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.t360.controller.Controller;

public class Utility extends Controller{

	
	static JavascriptExecutor js=(JavascriptExecutor) driver;
// ######################### ##################    Data Driven Implementation    ###############################################################

		  String path;
		  Workbook workbook;
		  Sheet sheet;
	//Non static block
		  {
				path="C:\\My Files\\T360_Regression_Automation\\src\\main\\java\\org\\t360\\testdata\\TestData.xlsx";
				fis=null;
				try {
					fis=new FileInputStream(path);
					workbook=WorkbookFactory.create(fis);
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
// ########################################################Object Repository ################################################
		  static String propertes_file_path="C:\\Users\\veeranarayana.jami\\workspace\\T360_Regression_Automation\\src\\main\\java\\org\\t360\\config\\config.properties";
		
		  static Properties prop;
	//static block	  
		  static{	 
		  File prop_file=new File(propertes_file_path);
		  FileInputStream prop_fis;
				  try {
					 prop_fis=new FileInputStream(prop_file);
					  prop=new Properties();
					  prop.load(prop_fis);
				  	} catch (FileNotFoundException e) {
					
					e.printStackTrace();
					}
				  	  catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}	  
		  
		 
			
			
			
			
			
			public int getRowNum(String sheetname, String celldata)
			{
				int rownum=0;
				sheet=workbook.getSheet(sheetname);
				

				for(int i=0;i<sheet.getLastRowNum();i++)
				{
				 
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
					{
						if((sheet.getRow(i+1).getCell(j).toString()).equals(celldata))
						{
							rownum=i+1;
						}
						else
							continue;
			
					}
					
				}
				
			

				return rownum;
				
			}
			
	public Object[][] getTestData(String sheetname)
	{
	
		sheet=workbook.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
		
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();	
			}			
		}			
		return data;
		
	}
	
	public Object[] getCellData(String sheetname,int rownum){
		
		sheet=workbook.getSheet(sheetname);
		Object[] arr=new Object[sheet.getRow(rownum).getLastCellNum()];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sheet.getRow(rownum).getCell(i).toString();
		}
		
		return arr;
		
	}
	
	public static boolean getInputResult(String val)
	{
		if(val.equalsIgnoreCase("pass"))
			return true;
		else
			return false;
		
	}
	
//################################################ Taking Screenshot  ################################################################

	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	 LocalDateTime now = LocalDateTime.now();  
	public static void takeScreenshotAtEndOfTest() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		}

//#######################################################   Mouse Actions     #################################################################
	
  public static void moveToAndClick(WebElement element)
  {
	  Actions action=new Actions(driver);
	  action.moveToElement(element).click();
	  	  
  }
		
  public static void scrollAndClick(WebElement element){
	  
	  
	  js.executeScript("arguments[0].scrollIntoView(true);", element);
	  
	  element.click();
	  
	  
  }
	
  
//########################################################      Wait Funtions    ##############################################################
  
  public static WebElement synchronizeAndFindElement(String xpath, WebDriver driver){
	  
	  
	  for(int i=0;i<Integer.parseInt(prop.getProperty("synchronize_time"));i++){
	  try{
		 WebElement element= driver.findElement(By.xpath(xpath));
		 return element;
	  }
	  catch(NoSuchElementException e)
	  {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			System.out.println("Finding Element "+xpath+ ".................");
		}
	  }
	  }
	  return null;
  }
  
  public static WebElement synchronizeAndFindElement(String xpath,int time, WebDriver driver){
	  
	  
	  for(int i=0;i<time;i++){
	  try{
		 WebElement element= driver.findElement(By.xpath(xpath));
		 return element;
	  }
	  catch(NoSuchElementException e)
	  {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			System.out.println("Finding Element "+xpath+ ".................");
		}
	  }
	  }
	  return null;
  }
  
  
  
  public static WebElement synchronizeAndFindElement(WebElement element, int time, WebDriver driver){
	  for(int i=0;i<time;i++){
	  try{
		 element.isDisplayed();
		 return element;
	  }
	  catch(NoSuchElementException e)
	  {
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
	
		}
	  }
	  }
	  return null;
  }
//################################################# Drop Down Functions   ###################################
/*  public void selectWithText(WebElement element, String text){
		
		Select select=new Select(element);
		List<WebElement> elements=select.getOptions();
		for(int i=0;i<elements.size();i++)
		{
			WebElement option=elements.get(0);
			if(option.getText().contains(text))
			 select.selectByIndex(i);
			else
				continue;
		}


}*/
	
}
