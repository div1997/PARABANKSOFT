package driverutills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class Driverlaunch
{

    private Driverlaunch () {}
    private static WebDriver driver;
    private static String uri ="http://192.168.1.6:4444";

     static void launchdriver( String browsername, String url)
    {
        if(browsername.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.getBrowserName();
            options.addArguments("--start-maximized");
            try {
                driver = new RemoteWebDriver(new URL(uri), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Drivermanager.setDriver(driver);
            Drivermanager.getDriver().get(url);


        }
        else if (browsername.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.getBrowserName();
            options.addArguments("--start-maximize","--headless=new");
            try {
                driver = new RemoteWebDriver(new URL(uri), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Drivermanager.setDriver(driver);
            Drivermanager.getDriver().get(url);
        } else if (browsername.equals("microsoftedge"))
        {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.getBrowserName();
            options.addArguments("--start-maximize");
            try {
                driver = new RemoteWebDriver(new URL(uri), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Drivermanager.setDriver(driver);
            Drivermanager.getDriver().get(url);

        }

    }

    static void teardowndriver()
    {
        Drivermanager.getDriver().quit();
        Drivermanager.setDriver(null);
        Drivermanager.unload();
    }

}
