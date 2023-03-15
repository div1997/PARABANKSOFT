package listenerutills;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrytestlistener implements IRetryAnalyzer
{
    private int count =0;
    private int retrylimit =2;
    @Override
    public boolean retry(ITestResult result)
    {
        if(count< retrylimit)
        {
            count++;
            return  true;
        }
        else
        {
            return false;
        }

    }
}
