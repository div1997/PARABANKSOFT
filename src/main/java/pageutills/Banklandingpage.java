package pageutills;

import driverutills.Drivermanager;
import enumutills.Waitenums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reportutills.Reportmanager;
import waitutills.Waitonaction;

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
        Waitonaction.perfoemwait(Waitenums.PRESENCE, leftmenubar);
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
       Waitonaction.perfoemwait(Waitenums.PRESENCE, customerloginlable);
      return Drivermanager.getDriver().findElement(customerloginlable).getText();
   }
   public String verifyusernamelable()
   {
       Waitonaction.perfoemwait(Waitenums.PRESENCE, usernamelable);
       return Drivermanager.getDriver().findElement(usernamelable).getText();
   }
   public String verifypasswordlable()
   {
       Waitonaction.perfoemwait(Waitenums.PRESENCE, passwordlable);
       return Drivermanager.getDriver().findElement(passwordlable).getText();
   }
  public Boolean isloginbuttondisplay()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, loginbutton);
      return Drivermanager.getDriver().findElement(loginbutton).isDisplayed();
  }
  public String verifyforgotlinktext()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, forgotpasswordlink);
      return Drivermanager.getDriver().findElement(forgotpasswordlink).getText();
  }
  public String verifyregisterlinktext()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, registerationlink);
      return Drivermanager.getDriver().findElement(registerationlink).getText();

  }
  public boolean verifyhomeicon()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, homeicon);
      return Drivermanager.getDriver().findElement(homeicon).isDisplayed();

  }
  public boolean verifyaboutusicon()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, abousicon);
      return Drivermanager.getDriver().findElement(abousicon).isDisplayed();

  }
  public boolean verifycontactusicon()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, contactusicon);
      return Drivermanager.getDriver().findElement(contactusicon).isDisplayed();

  }

  public List<String> verifyatmservices()
  {
      Waitonaction.perfoemwait(Waitenums.PRESENCE, atmServices);
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
      Waitonaction.perfoemwait(Waitenums.PRESENCE, onlineservices);
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
      Waitonaction.perfoemwait(Waitenums.PRESENCE, latestnews);
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
