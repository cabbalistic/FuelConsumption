import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginAbv {

    private WebDriver driver = new FirefoxDriver();

    public LoginAbv(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void openURL(String url){
        driver.get(url);
    }

    public void closeAbv(){
        driver.close();
    }


    public void handleGdprIframe() {
        By frameLocator = By.cssSelector("iframe#netinfo-consent-iframe");
        By closeBtnSelector = By.cssSelector("button.close-btn");

        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(closeBtnSelector));
        WebElement closeBtn = driver.findElement(closeBtnSelector);
        closeBtn.click();
        driver.switchTo().defaultContent();

    }

    public boolean login(String username, String pwd){

        driver.findElement(By.cssSelector("input#username")).click();
        driver.findElement(By.cssSelector("input#username")).sendKeys(username);
        driver.findElement(By.cssSelector("input#password")).click();
        driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
        driver.findElement(By.cssSelector("input#loginBut")).click();

        return driver.findElements( By.cssSelector("tr[__gwt_row='0'] div.fl") ).size() != 0;
    }

    public void printEmails() {

        for(WebElement tdata:driver.findElements(By.cssSelector("tr .inbox-cellTableSubjectColumn div"))) {
            System.out.println(tdata.getText());
        }
    }

    public void openMailBox(){
        driver.findElement(By.cssSelector("tr[__gwt_row='0'] div.fl")).click();

    }
}

