import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageCart extends PageBase {

    @FindBy(name="remove_cart_item")
    public WebElement removeItemButton;

    public PageCart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void removeItems() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("remove_cart_item")));
        List<WebElement> itemProducts = driver.findElements(By.cssSelector(".shortcut"));
        for(int i = itemProducts.size(); i > 0; i--){
            removeItemButton.click();
            wait.until(ExpectedConditions.stalenessOf(itemProducts.get(0)));
        }
    }
}