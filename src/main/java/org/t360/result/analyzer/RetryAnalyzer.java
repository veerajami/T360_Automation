package org.t360.result.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	
	int counter=0;
	int retrylimit=2;

	public boolean retry(ITestResult arg0) {
		if(counter>retrylimit)
		{
			counter++;
			return true;
		}
		else
		return false;
	}
	

}
