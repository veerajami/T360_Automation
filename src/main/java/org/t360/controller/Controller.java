package org.t360.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.t360.util.WebEventListener;

public class Controller {
	
	public static WebDriver driver;
	public static File src=new File("C:\\Users\\veeranarayana.jami\\workspace\\T360_Regression_Automation\\src\\main\\java\\org\\t360\\config\\config.properties");
	public static FileInputStream fis;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
  
	// static block
	
    
	
	public void initialize()
	{
		
		try {
			fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		  catch (IOException e) {
			e.printStackTrace();
		}
		
		String browser=prop.getProperty("browser");
		
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox_path"));
			driver=new FirefoxDriver();

		}
		else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\My Files\\chromedriver.exe");
			driver=new ChromeDriver();

		}
		
		else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", prop.getProperty("ie_path"));
			driver=new InternetExplorerDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
  
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait_time")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageload_time")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	

}
