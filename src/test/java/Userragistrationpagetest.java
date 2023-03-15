import annotationutills.an;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageutills.Registerationpage;
import reportutills.Reportlogger;

public class Userragistrationpagetest  extends Basetest
{
    Registerationpage rs;
    @Test
    @an(author = "divya varnwal", category = "smoke")
    public void verifyragistrationpagetitile()
    {
         rs = new Registerationpage();
        String title=  rs.openregistrationlinkinnewtabandverifytitle();
        Assertions.assertThat(title).isEqualTo("ParaBank | Register for Free Online Account Access");
        Reportlogger.pass(title);
    }

    @Test
    @an(author = "divya varnwal", category = "smoke")
    public void registeruser()
    {
        rs = new Registerationpage();
        String username = new Faker().name().username();
        rs.openinnewtab()
                .firstname(new Faker().name().firstName())
                .lastname(new Faker().name().lastName())
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


    }

}
