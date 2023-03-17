package driverutills;

import configfileutills.readconfigfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public final class lanuchbrowser
{
    private lanuchbrowser () {}
    public static void initdriver( String browsername)
    {
        Driverlaunch.launchdriver(browsername,
                readconfigfile.getvalueofconfigfile("url") );
    }

    public  static void quitdriver()
    {
        Driverlaunch.teardowndriver();
    }


}
