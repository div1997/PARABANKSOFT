package screenshotutills;

import driverutills.Drivermanager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class Image
{
    private Image () {}

    public static String getbase64image()
    {
        return ((TakesScreenshot) Drivermanager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
