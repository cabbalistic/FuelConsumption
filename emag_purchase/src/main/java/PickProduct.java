import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PickProduct extends BasePage{

    public PickProduct (WebDriver driver){
        super(driver);
    }

    private void chooseProduct(){
        //hover the PC category
        By productId = By.cssSelector(LoadProperties.getValue("productId"));
        WebElement product = findElementWithWait(productId, 20);
        product.click();
    }

    private void goToCart(){
        By cart = By.cssSelector(LoadProperties.getValue("goToCart"));
        WebElement cartButton = findElementWithWait(cart, 20);
        cartButton.click();
    }

    private void proceedToProductOrder(){
        By goToCart = By.cssSelector(LoadProperties.getValue("proceedCartButton"));
        WebElement proceedToCart =findElementWithWait(goToCart, 20);
        proceedToCart.click();
    }

    public void getProduct(){
        //chose product and go to cart
        chooseProduct();
        goToCart();
        proceedToProductOrder();
    }
}
