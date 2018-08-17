import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.stream.Collectors;


public class ProductCategory extends BasePage{

    public ProductCategory (WebDriver driver){
        super(driver);
    }

    private List<WebElement> getVisibleCategories(List<WebElement> inputList){
        return inputList.stream().filter(it -> it.isDisplayed()).collect(Collectors.toList());
    }

    public void chooseCategory(){
        //hover the PC category
        List<WebElement> mainMenu = driver.findElements(By.cssSelector(LoadProperties.getValue("categories")));
        Actions act = new Actions(driver);
        act.moveToElement(mainMenu.get(1)).build().perform();

        //wait condition
        WebElement waitForSubmenu =  findElementWithWait(By.cssSelector(LoadProperties.getValue("subcategories")));

        List<WebElement> subCategories = driver.findElements(By.cssSelector(LoadProperties.getValue("subcategories")));
        subCategories.get(findListIndexByString(subCategories,"Мастиленоструйни принтери")).click();
        }

}
