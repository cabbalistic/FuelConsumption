import org.openqa.selenium.*;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    private void deliveryWithCourier(){

        By courierDeliver = By.cssSelector(LoadProperties.getValue("courierRadio"));
        WebElement courierRadio = findElementWithWait(courierDeliver, 20);
        courierRadio.click();
    }

    private void paymentWithCard(){
        By payWithCard = By.cssSelector(LoadProperties.getValue("cardpaymentRadio"));
        WebElement payWithCardRadio = findElementWithWait(payWithCard, 20);
        payWithCardRadio.click();

        By purchaseProceedButton = By.cssSelector(LoadProperties.getValue("purchaseProceedButton"));
        WebElement proceedButton = findElementWithWaitClickable(purchaseProceedButton, 20);
        proceedButton.click();
    }

    public void checkOut(){
        //checkout details
        deliveryWithCourier();
        //payment with card
        paymentWithCard();
    }
}
