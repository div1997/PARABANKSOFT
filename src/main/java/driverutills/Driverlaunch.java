package driverutills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class Driverlaunch
{

    private Driverlaunch () {}
    private static WebDriver driver;

     static void launchdriver( String browsername, String url)
    {
        if(browsername.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(false);
            driver = new ChromeDriver(options);
            Drivermanager.setDriver(driver);
            Drivermanager.getDriver().get(url);


        }
        else
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
            Drivermanager.setDriver(driver);
        }

    }

    static void teardowndriver()
    {
        Drivermanager.getDriver().quit();
        Drivermanager.setDriver(null);
        Drivermanager.unload();
    }

}
