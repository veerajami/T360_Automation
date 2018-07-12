package selenium.samples;

import org.t360.controller.Controller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 {

	@BeforeMethod
	public void Start()
	{
		System.out.println("started");
		
	}
	@Test
	public void test1(){
		System.out.println("Tested");
	}
	
}
