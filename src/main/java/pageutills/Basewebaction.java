package pageutills;

import driverutills.Drivermanager;
import enumutills.Waitenums;
import org.openqa.selenium.By;
import waitutills.Waitonaction;

public class Basewebaction
{
    protected void clickon( Waitenums waitenums, By by)
    {
        Waitonaction.perfoemwait(waitenums, by).click();

    }
    protected  void sendkeys(Waitenums waitenums, By by, String message)
    {
        Waitonaction.perfoemwait(waitenums, by).sendKeys(message);
    }

    protected String gettitle()
    {
        return Drivermanager.getDriver().getTitle();
    }
}
