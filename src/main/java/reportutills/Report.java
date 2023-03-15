package reportutills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public final class Report
{
    private Report () {}
     private static ExtentReports exreport = new ExtentReports();
    private static ExtentTest  extest;
      public static void initreport()
    {
        ExtentSparkReporter exspark = new ExtentSparkReporter("report.html");
        exreport.attachReporter(exspark);
    }
   public  static void teardownreprot()
    {
        exreport.flush();
    }
  public   static void creattest(String testname)
    {
          extest = exreport.createTest(testname);
            Reportmanager.setreprot(extest);
    }

}
