package reportutills;

import com.aventstack.extentreports.ExtentTest;

public final class Reportmanager
{

    private Reportmanager (){}
 private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();
     static ExtentTest getreport()
     {
          return extest.get();
     }

     static void setreprot(ExtentTest test)
     {
         extest.set(test);
     }
}
