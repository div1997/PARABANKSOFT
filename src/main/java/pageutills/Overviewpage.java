package pageutills;

import driverutills.Drivermanager;
import org.openqa.selenium.By;

public class Overviewpage extends  Basewebaction
{
    By logout = By.xpath("//div[@id='leftPanel']//li[8]");
    public void logout()
    {
        Drivermanager.getDriver().findElement(logout).click();
    }
    
}

