package pageutills;

import driverutills.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Registerationpage extends Basewebaction
{
    By registerationlink = By.xpath("//div[@id='loginPanel']//a[contains (text(),'Register')]");

    public String openregistrationlinkinnewtabandverifytitle()
    {
        WebElement openinnewtab = Drivermanager.getDriver().findElement(registerationlink);
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        openinnewtab.sendKeys(selectLinkOpeninNewTab);
        Set<String> windowset = Drivermanager.getDriver().getWindowHandles();
        List windowlist = new ArrayList<>(windowset);
       String parent = windowlist.get(0).toString();
        String child = windowlist.get(1).toString();
        Drivermanager.getDriver().switchTo().window(child);
        return Drivermanager.getDriver().getTitle();


    }




    By firstname = By.xpath("//table[@class='form2']//tbody//tr[1]//td[2]//input");
    By lastname =By.xpath("//table[@class='form2']//tbody//tr[2]//td[2]//input");
    By address =By.xpath("//table[@class='form2']//tbody//tr[3]//td[2]//input");
    By city =By.xpath("//table[@class='form2']//tbody//tr[4]//td[2]//input");
    By state =By.xpath("//table[@class='form2']//tbody//tr[5]//td[2]//input");
    By zipcode=By.xpath("//table[@class='form2']//tbody//tr[6]//td[2]//input");
    By phone = By.xpath("//table[@class='form2']//tbody//tr[7]//td[2]//input");
    By ssn = By.xpath("//table[@class='form2']//tbody//tr[8]//td[2]//input");
    By username =By.xpath("//table[@class='form2']//tbody//tr[10]//td[2]//input");
    By password =By.xpath("//table[@class='form2']//tbody//tr[11]//td[2]//input");
    By confrim =By.xpath("//table[@class='form2']//tbody//tr[12]//td[2]//input");
    By submit = By.xpath("//table[@class='form2']//tbody//tr[13]//td[2]//input");

    public Registerationpage openinnewtab()
    {
        WebElement openinnewtab = Drivermanager.getDriver().findElement(registerationlink);
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        openinnewtab.sendKeys(selectLinkOpeninNewTab);
        Set<String> windowset = Drivermanager.getDriver().getWindowHandles();
        List windowlist = new ArrayList<>(windowset);
        String parent = windowlist.get(0).toString();
        String child = windowlist.get(1).toString();
        Drivermanager.getDriver().switchTo().window(child);
        return this;

    }

    public Registerationpage firstname(String fn)
    {
        Drivermanager.getDriver().findElement(firstname).sendKeys(fn);
        return this;
    }
    public Registerationpage lastname(String ln)
    {
        Drivermanager.getDriver().findElement(lastname).sendKeys(ln);
        return this;
    }

    public Registerationpage address(String add)
    {
        Drivermanager.getDriver().findElement(address).sendKeys(add);
        return this;
    }
    public Registerationpage city( String ct)
    {
        Drivermanager.getDriver().findElement(city).sendKeys(ct);
        return this;
    }
    public Registerationpage state( String st)
    {
        Drivermanager.getDriver().findElement(state).sendKeys(st);
        return this;
    }
    public Registerationpage zipcode(String zip)
    {
        Drivermanager.getDriver().findElement(zipcode).sendKeys(zip);
        return this;
    }

    public Registerationpage phone (String ph)
    {
        Drivermanager.getDriver().findElement(phone).sendKeys(ph);
        return this;
    }

    public Registerationpage ssn (String sn)
    {
        Drivermanager.getDriver().findElement(ssn).sendKeys(sn);
        return this;
    }
  public Registerationpage username(String un)
  {
      Drivermanager.getDriver().findElement(username).sendKeys(un);
      return this;
  }
  public Registerationpage password (String pd)
  {
      Drivermanager.getDriver().findElement(password).sendKeys(pd);
      return this;
  }
  public Registerationpage confrim(String rp)
  {
      Drivermanager.getDriver().findElement(confrim).sendKeys(rp);
      return this;
  }
  public void submit()
  {
      Drivermanager.getDriver().findElement(submit).submit();

  }
}

