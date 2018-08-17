import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class EmagLogin extends BasePage{


    public EmagLogin(WebDriver driver){
       super(driver);
       driver.manage().window().maximize();
    }

    public void openLoginPage() {
        String url = LoadProperties.getValue("url");
        driver.get(url);
    }

    public void goToMainPage(){
        By mainPage = By.cssSelector(LoadProperties.getValue("mainPage"));
        WebElement backBtn = driver.findElement(mainPage);
        backBtn.click();
    }

    public void goMyAccount() {
        //find and click to MyAccount
        By myAccount = By.cssSelector(LoadProperties.getValue("myAccount"));
        WebElement myAccountBtn = findElementWithWait(myAccount, 20);
        myAccountBtn.click();
    }

    private void proceedBtn() {
        //proceed button used for username and password
        By proceed = By.cssSelector(LoadProperties.getValue("proceedButton"));
        WebElement proceedBtn = findElementWithWait(proceed, 20);
        proceedBtn.click();
    }

    public void typeUsername() {
        //type in username
        By accountInput = By.cssSelector(LoadProperties.getValue("accoutInput"));
        WebElement inputUsername =  findElementWithWait(accountInput, 20);
        inputUsername.click();
        inputUsername.sendKeys(LoadProperties.getValue("username"));
        proceedBtn();
    }

    public void typePassword() {
        //type in username
        By passwordInput = By.cssSelector(LoadProperties.getValue("passwordInput"));
        WebElement inputPassword = findElementWithWait(passwordInput, 20);
        inputPassword.click();
        inputPassword.sendKeys(LoadProperties.getValue("password"));
        proceedBtn();
    }

    public void openWebPage(){
        openLoginPage();
        goToMainPage();
    }

    public void userLogin(){
        // go to account login form
        goMyAccount();

        // login the user
        typeUsername();
        typePassword();
    }


}
