import annotationutills.an;
import com.github.javafaker.Faker;
import driverutills.Drivermanager;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pageutills.Registerationpage;
import pageutills.Registerpage;
import reportutills.Reportlogger;

public class Userragistrationpagetest  extends Basetest
{
    Registerationpage rs;

    SoftAssertions softly = new SoftAssertions();
    @Test
    @an(author = "divya varnwal", category = "smoke")
    public void verifyragistrationpagetitile()
    {
         rs = new Registerationpage();
        String title=  rs.openregistrationlinkinnewtabandverifytitle();
        softly.assertThat(title).isEqualTo("ParaBank | Register for Free Online Account Access");
        Reportlogger.pass(title);
        softly.assertAll();
    }

    @Test
    @an(author = "divya varnwal", category = "smoke")
    public void registeruser()
    {
        rs = new Registerationpage();
        String fn = new Faker().name().firstName();
        String ln = new Faker().name().lastName();
        String username = new Faker().name().username();
         Registerpage rp = rs.openinnewtab()
                .firstname(fn)
                .lastname(ln)
                .address(new Faker().address().fullAddress())
                .city(new Faker().address().cityName())
                .state(new Faker().address().state())
                .zipcode(new Faker().address().zipCode())
                .phone(new Faker().phoneNumber().cellPhone())
                .ssn(new Faker().number().digits(12))
                .username(username)
                .password("Test123@$")
                .confrim("Test123@$")
                .submit();
        Reportlogger.info(" User name is "+username);
        Reportlogger.info("User password is Test123@$");
        Reportlogger.info(Drivermanager.getDriver().getCurrentUrl());
        Reportlogger.info((Drivermanager.getDriver().getTitle()));

         String un = rp.username();
         softly.assertThat(un).isEqualTo( "Welcome "+un);
         String fulln = rp.fullname();
         softly.assertThat(fulln).isEqualTo("Welcome "+fn+ln);
         softly.assertAll();
    }

    @Test
    public void submenupbar()
    {
        Homepagetest hp = new Homepagetest();
        hp.verifysubmenubar();
    }
    @Test
    public void icons()
    {
        Homepagetest hp = new Homepagetest();
        hp.verifyiconsonlandingpage();
    }

}
