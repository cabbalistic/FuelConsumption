import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginAbv {
    protected WebDriver driver;

    public LoginAbv(WebDriver driver){
        this.driver = driver;
    }

    public void openAbv(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeAbv(){
        driver.close();
    }

    public void waitElement() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void handleGdprIframe() {
        waitElement();
        WebElement iframe = driver.findElement(By.cssSelector("iframe#netinfo-consent-iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button.close-btn")).click();
        driver.switchTo().defaultContent();
    }

    public boolean login(String username, String pwd){
        boolean testFlag = false;
        driver.findElement(By.cssSelector("input#username")).click();
        driver.findElement(By.cssSelector("input#username")).sendKeys(username);
        driver.findElement(By.cssSelector("input#password")).click();
        driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);
        driver.findElement(By.cssSelector("input#loginBut")).click();
        if ( driver.findElements( By.cssSelector("td.abv-settings") ).size() != 0) testFlag = true;
        return testFlag;
    }
}
