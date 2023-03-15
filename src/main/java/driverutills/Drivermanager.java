package driverutills;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public  final class Drivermanager
{
    private Drivermanager () {}

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

     public static  WebDriver getDriver()
    {
      return driver.get();
    }

    static void setDriver (WebDriver driverref)
    {
        driver.set(driverref);
    }

    public static void unload()
    {
        driver.remove();
    }




}
