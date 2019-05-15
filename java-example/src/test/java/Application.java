import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application {

    private WebDriver driver;
    private PageMain mainPage;
    private PageItem itemPage;
    private PageCart cartPage;
    public WebDriverWait wait;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new PageMain(driver);
        itemPage = new PageItem(driver);
        cartPage = new PageCart(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void quit() {
        driver.quit();
    }

    public void cartItemsAddAndRemove() {
        for(int i = 1; i < 4; i++) {
            mainPage.open();
            mainPage.items.get(0).click();
            if(!itemPage.optionsList.isEmpty()){
                itemPage.option.click();
                itemPage.optionsOption.click();
            }
            itemPage.addToCartButton.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.navigate().refresh();
            String text = Integer.toString(i);
            itemPage.checkQuantity(text);
        }
        itemPage.checkoutButton.click();
        cartPage.removeItems();
    }
}