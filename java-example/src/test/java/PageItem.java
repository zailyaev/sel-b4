import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageItem extends PageBase {

    @FindBy(name="options[Size]")
    public List<WebElement> optionsList;

    @FindBy(name="options[Size]")
    public WebElement option;

    @FindBy(css="option[value=\"Small\"]")
    public WebElement optionsOption;

    @FindBy(name="add_cart_product")
    public WebElement addToCartButton;

    @FindBy(xpath="//a[text() = 'Checkout »']")
    public WebElement checkoutButton;

    public PageItem(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkQuantity(String text) {
        WebElement quantity = driver.findElement(By.className("quantity"));
        wait.until(ExpectedConditions.textToBePresentInElement(quantity, text));
    }
}