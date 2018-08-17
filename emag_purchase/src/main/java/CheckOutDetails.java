import org.openqa.selenium.*;

public class CheckOutDetails extends BasePage {

    public CheckOutDetails(WebDriver driver){
        super(driver);
    }

    private void chooseDeliveryWithCourier(){

        By courierDeliver = By.cssSelector(LoadProperties.getValue("courierRadio"));
        WebElement courierRadio = findElementWithWait(courierDeliver, 20);
        courierRadio.click();
    }

    private void choosePaymentWithCard(){
        By payWithCard = By.cssSelector(LoadProperties.getValue("cardpaymentRadio"));
        WebElement payWithCardRadio = findElementWithWait(payWithCard, 20);
        payWithCardRadio.click();

        By purchaseProceedButton = By.cssSelector(LoadProperties.getValue("purchaseProceedButton"));
        WebElement proceedButton = findElementWithWait(purchaseProceedButton, 20);
        proceedButton.click();
    }

    public void checkOut(){
        //checkout details
        chooseDeliveryWithCourier();
        //payment with card
        choosePaymentWithCard();
    }
}
