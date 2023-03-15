import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageutills.Banklandingpage;
import annotationutills.an;
import reportutills.Reportlogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Homepagetest  extends  Basetest
{

    Banklandingpage bk;
    @Test(enabled = true)
    @an (author = "divya varnwal", category = "smoke")
    public void verifytitle()
    {
         bk = new Banklandingpage();
        String title =  bk.verifytitle();
        Assertions.assertThat(title).isEqualTo("ParaBank | Welcome | Online Banking");
    }
    @Test
    @an(author = "divya", category = "smoke")
    public void verifysubmenubar()
    {
         bk = new Banklandingpage();
        int leftmenusize = bk.verifyleftmenu().size();
        Reportlogger.info("left menu size is " + leftmenusize);
        Assertions.assertThat(leftmenusize).isEqualTo(6);
        for (String name : bk.verifyleftmenu())
        {
            if (name.equals("Solutions") || name.equals("About Us") || name.equals("Services") || name.equals("Products") || name.equals("Locations")
                    || name.equals("Admin Page"))
            {
                Reportlogger.info("Leftmenu :" + name);

            } else
            {
                Reportlogger.info(" left menuname " + name + " is missing");
            }


        }
    }
   @Test
   @an(author = "divya Varnwal", category = "smoke")
    public void isloginlabledisplay()
   {
       bk = new Banklandingpage();
       Assertions.assertThat(bk.verifyloginlable()).isEqualTo("Customer Login");
       Reportlogger.info("lable is display"+bk.verifyloginlable());
   }
   @Test
   @an(author = "divya Varnwal", category = "smoke")
    public  void verifyloginformlable()
   {
       bk = new Banklandingpage();
       Assertions.assertThat(bk.verifyusernamelable()).isEqualTo("Username");
       Reportlogger.info("username lable is display"+bk.verifyusernamelable());
       Assertions.assertThat(bk.verifypasswordlable()).isEqualTo("Password");
       Reportlogger.info("password lable is display"+bk.verifypasswordlable());
       Assertions.assertThat(bk.isloginbuttondisplay()).isEqualTo(true);
       Reportlogger.info("login button lable is display : "+bk.isloginbuttondisplay());
       Assertions.assertThat(bk.verifyforgotlinktext()).isEqualTo("Forgot login info?");
       Reportlogger.info("forgot login  lable is display"+bk.verifyforgotlinktext());
       Assertions.assertThat(bk.verifyregisterlinktext()).isEqualTo("Register");
       Reportlogger.info("user register lable is display"+bk.verifyregisterlinktext());

   }

   @Test
   @an(author = "divya Varnwal", category = "smoke")
    public void verifyiconsonlandingpage()
    {
        bk = new Banklandingpage();
        Assertions.assertThat(bk.verifyhomeicon()).isEqualTo("home");
        Reportlogger.info("login button lable is display : "+bk.verifyhomeicon());
        Assertions.assertThat(bk.verifyaboutusicon()).isEqualTo("about");
        Reportlogger.info("login button lable is display : "+bk.verifyaboutusicon());
        Assertions.assertThat(bk.verifycontactusicon()).isEqualTo("contact");
       Reportlogger.info("login button lable is display : "+bk.verifycontactusicon());

    }
    @Test
    @an(author = "divya Varnwal", category = "smoke")
    public  void verifyatmservices()
    {
        bk = new Banklandingpage();
        int size = bk.verifyatmservices().size();
        Reportlogger.info(" ATM Services are "+(size-1));
        for(String name : bk.verifyatmservices())
        {
            if(name.equals("Withdraw Funds")|| name.equals("Transfer Funds")|| name.equals("Check Balances")
            ||name.equals("Make Deposits"))
            {
                Reportlogger.info("ATM Services: " +name);
            }
            else
            {
                Reportlogger.info("Atm service"+ name+"is missing on page ");
            }
        }
    }
@Test
@an(author = "divya Varnwal", category = "smoke")
    public void verifyonlineservices()
{
    bk = new Banklandingpage();
    int size = bk.verifyonlineservices().size();
    Reportlogger.info("online services are"+ (size-1));
    for(String name : bk.verifyonlineservices())
    {
        if(name.equals("Bill Pay")|| name.equals("Account History")|| name.equals("Transfer Funds"))
        {
            Reportlogger.info("Online services are" +name);

        }
        else
        {
            Reportlogger.info("Online service "+name+"is missing");
        }
    }
}

@Test
@an(author = "divya Varnwal", category = "smoke")
    public void verifynewslableanddate()
{

    bk = new Banklandingpage();
    int size = bk.verifylatestnewstitles().size();
    Reportlogger.info("news count is"+ (size-1));
    for(String name : bk.verifylatestnewstitles())
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = name;

        if(currentdate.equals(dtf.format(now)))
        {
            Reportlogger.info(name);
        }
        else
        {
            Reportlogger.info("news is old date"+currentdate);
        }
    }
}
}
