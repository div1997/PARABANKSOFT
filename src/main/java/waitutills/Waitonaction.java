package waitutills;

import driverutills.Drivermanager;
import enumutills.Waitenums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waitonaction
{
    public static WebElement  element = null;
    public  static WebElement perfoemwait(Waitenums waitenums , By by)
    {
        if(waitenums == Waitenums.CLICKABLE)
        {
            element = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitenums == Waitenums.VISIBLE)
        {
            element = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitenums == Waitenums.PRESENCE)
        {
            element = new WebDriverWait(Drivermanager.getDriver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else
        {
            element.click();
        }

         return element;

    }
}
