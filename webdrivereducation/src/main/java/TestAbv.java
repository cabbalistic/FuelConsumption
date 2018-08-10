import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class TestAbv {

    private String username = "vanko_mayora";
    private String pwd = "526";
    private boolean testFlag;
    private LoginAbv page;

    @BeforeTest
    public void openMainPage(){
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");
        page = PageFactory.initElements(new FirefoxDriver(), LoginAbv.class);
        page.openAbv("http://www.abv.bg");
        page.handleGdprIframe();
    }

    @AfterTest
    public void closeBrowser(){
        page.closeAbv();
    }

    @Test
    public void userLogin(){
        testFlag = page.login(username,pwd);
        Assert.assertTrue(testFlag);
    }

}
