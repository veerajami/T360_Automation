package selenium.samples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelRowData {

		String path;
	
		Workbook workbook;
		FileInputStream fis;
		Sheet sheet;
		{
			path="C:\\Users\\veeranarayana.jami\\workspace\\T360_Regression_Automation\\src\\main\\java\\org\\t360\\testdata\\TestData.xlsx";
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
	
	public Object[] getRowData(String sheetname,int rownum){
		
		sheet=workbook.getSheet(sheetname);
		Object[] arr=new Object[sheet.getRow(rownum).getLastCellNum()];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sheet.getRow(rownum).getCell(i).toString();
		}
		
		return arr;
		
	}
	@Test
	public void Test1()
	{
		int rownum=getRowNum("Login Users", "System Administrator");
		Object[] arr=getRowData("Login Users", getRowNum("Login Users", "System Administrator"));
		String username=(String) arr[0];
		String password=(String) arr[1];
		System.out.println(username);
		System.out.println(password);
	
	}
		
}
