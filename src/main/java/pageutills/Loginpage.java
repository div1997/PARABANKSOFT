package pageutills;

import driverutills.Drivermanager;
import enumutills.Waitenums;
import org.openqa.selenium.By;

public class Loginpage extends Basewebaction
{
    By usernamelable = By.xpath("//div[@id='loginPanel']//form//p[1]");
    By passwordlable = By.xpath("//div[@id='loginPanel']//form//p[2]");
    By loginbutton = By.xpath("//div[@id='loginPanel']//form//div[3]");

    public Overviewpage loginwithhuser (String username, String password)
    {
        sendkeys(Waitenums.PRESENCE, usernamelable, username);
        sendkeys(Waitenums.PRESENCE, passwordlable, password);
        clickon(Waitenums.PRESENCE, loginbutton);
        return new Overviewpage();
    }

}
