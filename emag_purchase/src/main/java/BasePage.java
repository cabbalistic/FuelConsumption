import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElementWithWait(By by, long timeOutInSeconds){
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public WebElement findElementWithWait(By by){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public int findListIndexByString(List<WebElement> lst,String str) {
        int n = 0;
        for (int i = 0; i < lst.size(); i++) {
            String tmp = lst.get(i).getText();
            if(tmp.equals(str)) n=i;
        }
        return n;
    }
    public void waitForLoad(WebDriver driver){
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
