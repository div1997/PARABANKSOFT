import driverutills.Driverlaunch;
import driverutills.Drivermanager;
import driverutills.lanuchbrowser;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageutills.Banklandingpage;

import javax.swing.*;

public class Basetest
{
   @BeforeMethod
   @Parameters("browsername")
    public void openbrowser(String browsername)
   {
       lanuchbrowser.initdriver(browsername);
   }

    @AfterMethod
    public void closebrowser()
    {
       lanuchbrowser.quitdriver();
   }
}
