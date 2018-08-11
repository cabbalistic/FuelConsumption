//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class TestAbv {

    private String username = "vanko_mayora";
    private String pwd = "526";
    private boolean testFlag;
    public LoginAbv loginAbv;

    @BeforeTest
    public void openMainPage(){
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");
        loginAbv = new LoginAbv();
        loginAbv.openURL("http://www.abv.bg");
        loginAbv.handleGdprIframe();
    }

    @AfterTest
    public void closeBrowser(){
       // loginAbv.closeAbv();
    }

    @Test
    public void userCanLogin(){
        testFlag = loginAbv.login(username,pwd);
        loginAbv.openMailBox();
        loginAbv.printEmails();
        Assert.assertTrue(testFlag);
    }

}
