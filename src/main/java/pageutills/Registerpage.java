package pageutills;

import driverutills.Drivermanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Registerpage  extends Basewebaction
{
 private By welcomeusername = By.xpath("//div//h1");
 private By welcomefullname = By.xpath("//div[@id='leftPanel']//p");
 private  By accountservices = By.xpath("//div[@id='leftPanel']//h2");
 private  By listofservices = By.xpath("//div[@id='leftPanel']//ul//li");

 public String username()
 {
     return Drivermanager.getDriver().findElement(welcomeusername).getText();
 }
 public String fullname()
 {
     return  Drivermanager.getDriver().findElement(welcomefullname).getText();

 }
 public String accountservices()
 {
     return Drivermanager.getDriver().findElement(accountservices).getText();
 }
 public List<String> accountservicesname()
 {
     List<WebElement> list = Drivermanager.getDriver().findElements(listofservices);
     List<String> accountservices = new ArrayList<>();
     for(WebElement element : list)
     {
         accountservices.add(element.getText());
     }
     return  accountservices;
 }
}
