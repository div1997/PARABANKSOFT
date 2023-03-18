package driverutills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.bidi.log.ConsoleLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public final class Driverlaunch
{

    private Driverlaunch () {}
    private static WebDriver driver;
    private static String uri ="http://192.168.1.6:4444";

     static void launchdriver( String browsername, String url)

    {
        try
    {
        if (Objects.isNull(Drivermanager.getDriver()))
        {
            if (browsername.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.getBrowserName();
                options.addArguments("--start-maximized", "--headless=new");
                driver = new RemoteWebDriver(new URL(uri), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().deleteAllCookies();
                driver.manage().logs().toString();
                driver.manage().timeouts().getPageLoadTimeout();
                driver.manage().timeouts().getScriptTimeout();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                Drivermanager.setDriver(driver);
                Drivermanager.getDriver().get(url);


            } else if (browsername.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.getBrowserName();
                options.addArguments("--start-maximize");
                driver = new RemoteWebDriver(new URL(uri), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().deleteAllCookies();
                driver.manage().logs().toString();
                driver.manage().timeouts().getPageLoadTimeout();
                driver.manage().timeouts().getScriptTimeout();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                Drivermanager.setDriver(driver);
                Drivermanager.getDriver().get(url);
            } else if (browsername.equalsIgnoreCase("microsoftedge"))
            {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.getBrowserName();
                options.addArguments("--start-maximize");
                driver = new RemoteWebDriver(new URL(uri), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().deleteAllCookies();
                driver.manage().logs().toString();
                driver.manage().timeouts().getPageLoadTimeout();
                driver.manage().timeouts().getScriptTimeout();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                Drivermanager.setDriver(driver);
                Drivermanager.getDriver().get(url);
            }
        }
    }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e.getCause());
        }
        catch (ScriptTimeoutException e)
        {
           // throw new RuntimeException(e.getLocalizedMessage());
            throw new RuntimeException("script timeout is"+driver.manage().timeouts().getScriptTimeout());
        } catch (NoSuchSessionException e)
        {
            throw new RuntimeException(e.getRawMessage());
        } catch (WebDriverException e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    static void teardowndriver()
    {
        if(Objects.nonNull(Drivermanager.getDriver())) {
            Drivermanager.getDriver().quit();
            Drivermanager.setDriver(null);
            Drivermanager.unload();
        }
    }

}
