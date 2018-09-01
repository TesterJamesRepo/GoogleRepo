package analyzers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int cnt=0;
	int retryCnt=2;

	public boolean retry(ITestResult result){

	if(cnt<retryCnt){
		cnt++;
		return true;
	}
	else 
		return false;
	}


}
