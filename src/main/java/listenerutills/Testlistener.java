package listenerutills;

import annotationutills.an;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reportutills.Report;
import reportutills.Reportlogger;

public class Testlistener implements  ISuiteListener, ITestListener
{
    @Override
    public void onStart(ISuite suite)
    {
        Report.initreport();
    }
    @Override
    public void onFinish(ISuite suite)
    {
        Report.teardownreprot();
    }
    @Override
    public void onTestStart(ITestResult result)
    {
       Report.creattest(result.getName());
       Reportlogger.info(result.getInstanceName());
        String [] author =  result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(an.class).author();
        Reportlogger.assignauthor(author);
        String [] category =  result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(an.class).category();
        Reportlogger.assigncategory(category);

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Reportlogger.info("test is pass");
        //Report.creattest(result.getName());
        Reportlogger.pass(result.getName() +" is success");
        Reportlogger.pass(String.valueOf(result.getStatus()));



    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        // not implemented
        Reportlogger.info("test failed");
        Reportlogger.failed(String.valueOf(result.getThrowable()));
    }
}
