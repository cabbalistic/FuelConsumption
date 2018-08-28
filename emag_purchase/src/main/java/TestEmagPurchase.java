import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class TestEmagPurchase{

    public LoadProperties property;
    public WebDriver driver;
    public EmagLoginPage emagLogin;
    public ProductCategoryPage productCategory;
    public ProductPage pickProduct;
    public CheckOutPage checkOutDetails;


    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][] { { "ivan_johnrazz@abv.bg", "asda" }, { "testuser_1", "Test@123" }};

    }

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");

        driver = new FirefoxDriver();
        emagLogin = new EmagLoginPage(driver);
        productCategory = new ProductCategoryPage(driver);
        pickProduct = new ProductPage(driver);
        checkOutDetails = new CheckOutPage(driver);
    }

    @AfterMethod
    public void afterTest(){
       driver.close();
    }

    @Test  (dataProvider = "Authentication")
    public void userCanPlaceOrderUsingCourierDelivery(String usrname, String pwd){
        //open url and go to main page
        emagLogin.openPage();

        //login page
        emagLogin.goMyAccount();

        // login the user
        emagLogin.typeUsernameAndPassword(usrname, pwd);

        //choose category and subcategory
        productCategory.productCategory();

        //chose product and go to cart
        pickProduct.getProduct();

        //checkout details
        checkOutDetails.checkOut();

        Assert.assertEquals("https://www.emag.bg/cart/summary",driver.getCurrentUrl());

   }

}
