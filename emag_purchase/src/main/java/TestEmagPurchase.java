import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestEmagPurchase{

    public LoadProperties property;
    public WebDriver driver;
    public EmagLoginPage emagLogin;
    public ProductCategoryPage productCategory;
    public ProductPage pickProduct;
    public CheckOutPage checkOutDetails;


    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");

        driver = new FirefoxDriver();
        emagLogin = new EmagLoginPage(driver);
        productCategory = new ProductCategoryPage(driver);
        pickProduct = new ProductPage(driver);
        checkOutDetails = new CheckOutPage(driver);
    }

    @AfterTest
    public void afterTest(){
       driver.close();
    }

    @Test
    public void userCanPlaceOrderUsingCourierDelivery(){
        //open url and go to main page
        emagLogin.openPage();

        //login
        emagLogin.userLogin();

        //choose category and subcategory
        productCategory.productCategory();

        //chose product and go to cart
        pickProduct.getProduct();

        //checkout details
        checkOutDetails.checkOut();

        Assert.assertEquals("https://www.emag.bg/cart/summary",driver.getCurrentUrl());
   }

}
