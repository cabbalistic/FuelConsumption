import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestEmagPurchase{

    public LoadProperties property;
    public WebDriver driver;
    public EmagLogin emagLogin;
    public ProductCategory productCategory;
    public PickProduct pickProduct;
    public CheckOutDetails checkOutDetails;


    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");

        driver = new FirefoxDriver();
        emagLogin = new EmagLogin(driver);
        productCategory = new ProductCategory(driver);
        pickProduct = new PickProduct(driver);
        checkOutDetails = new CheckOutDetails(driver);
    }

    @AfterTest
    public void afterTest(){
       driver.close();
    }

    @Test
    public void userCanPlaceOrderUsingCourierDelivery(){
        //open url and go to main page
        emagLogin.openWebPage();

        //login
        emagLogin.userLogin();

        //choose category and subcategory
        productCategory.chooseCategory();

        //chose product and go to cart
        pickProduct.getProduct();

        //checkout details
        checkOutDetails.checkOut();

        Assert.assertEquals("https://www.emag.bg/cart/summary",driver.getCurrentUrl());
   }

}
