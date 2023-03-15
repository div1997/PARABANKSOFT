package pageutills;

import driverutills.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reportutills.Reportmanager;

import java.util.ArrayList;
import java.util.List;

public class Banklandingpage extends Basewebaction
{
    By leftmenubar = By.xpath("//ul[@class='leftmenu']//li");
    By customerloginlable = By.xpath("//div[@id='leftPanel']//h2");
    By usernamelable = By.xpath("//div[@id='loginPanel']//form//p[1]");
    By passwordlable = By.xpath("//div[@id='loginPanel']//form//p[2]");
    By loginbutton = By.xpath("//div[@id='loginPanel']//form//div[3]");
    By forgotpasswordlink = By.xpath("//div[@id='loginPanel']//a[contains (text(),'Forgot login info')]");
    By registerationlink = By.xpath("//div[@id='loginPanel']//a[contains (text(),'Register')]");
    By homeicon =By.xpath("//div[@id='headerPanel']//ul[2]//a[contains(text(),'home')]");
    By abousicon =By.xpath("//div[@id='headerPanel']//ul[2]//a[contains(text(),'about')]");
    By contactusicon = By.xpath("//div[@id='headerPanel']//ul[2]//a[contains(text(),'contact')]");
    By atmServices = By.xpath("//div[@id='rightPanel']//ul[@class='services']//li");
    By onlineservices = By.xpath("//div[@id='rightPanel']//ul[@class='servicestwo']//li");
    By  latestnews = By.xpath("//div[@id='rightPanel']//ul[@class='events']//li");

    public  String verifytitle()
    {
           return gettitle();
    }
    public List<String> verifyleftmenu()
    {
        List<WebElement> leftmeneubarname = Drivermanager.getDriver().findElements(leftmenubar);
       List <String> menubar = new ArrayList<>() ;
        for(WebElement element : leftmeneubarname)
        {
             menubar.add(element.getText());

        }
        return  menubar;

    }

   public String verifyloginlable()
   {
      return Drivermanager.getDriver().findElement(customerloginlable).getText();
   }
   public String verifyusernamelable()
   {
       return Drivermanager.getDriver().findElement(usernamelable).getText();
   }
   public String verifypasswordlable()
   {
       return Drivermanager.getDriver().findElement(passwordlable).getText();
   }
  public Boolean isloginbuttondisplay()
  {
      return Drivermanager.getDriver().findElement(loginbutton).isDisplayed();
  }
  public String verifyforgotlinktext()
  {
      return Drivermanager.getDriver().findElement(forgotpasswordlink).getText();
  }
  public String verifyregisterlinktext()
  {
      return Drivermanager.getDriver().findElement(registerationlink).getText();

  }
  public String verifyhomeicon()
  {
      return Drivermanager.getDriver().findElement(homeicon).getText();

  }
  public String verifyaboutusicon()
  {
      return Drivermanager.getDriver().findElement(abousicon).getText();

  }
  public String verifycontactusicon()
  {
      return Drivermanager.getDriver().findElement(contactusicon).getText();

  }

  public List<String> verifyatmservices()
  {
      List<WebElement> atmservice = Drivermanager.getDriver().findElements(atmServices);
      List<String> atmservicenames = new ArrayList<>();
      for(WebElement element : atmservice)
      {
          String name = element.getText();
          atmservicenames.add(name);
      }
      return atmservicenames;
  }

  public  List<String> verifyonlineservices()
  {
      List<WebElement> onlineservice = Drivermanager.getDriver().findElements(onlineservices);
      List<String> onlineservicename = new ArrayList<>();
      for(WebElement element : onlineservice)
      {
          String name = element.getText();
          onlineservicename.add(name);
      }
      return onlineservicename;
  }

  public List<String> verifylatestnewstitles()
  {
      List<WebElement> latestnewlable = Drivermanager.getDriver().findElements(latestnews);
      List<String> newslable = new ArrayList<>();
      for(WebElement element : latestnewlable)
      {
          String name = element.getText();
          newslable.add(name);
      }
      return newslable;

  }
}
