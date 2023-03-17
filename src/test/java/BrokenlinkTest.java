import annotationutills.an;
import driverutills.Drivermanager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import reportutills.Reportlogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenlinkTest extends Basetest {
    @Test
    @an(author = "divya varnwal", category = "smoke")
    public void findbrokenlink()
    {

        List<WebElement> linklist = Drivermanager.getDriver().findElements(By.tagName("a"));
        for (WebElement element : linklist)
        {
            try {
                String url = element.getAttribute("href");
                URL linkurl = new URL(url);
                HttpURLConnection con = (HttpURLConnection) linkurl.openConnection();
                con.connect();
                int responsecode = con.getResponseCode();
                if (responsecode >= 400)
                {

                    Reportlogger.info(url+ "is not valid and response code is"+responsecode);
                } else
                {

                    Reportlogger.info(url+ "is  valid and response code is"+responsecode);
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
