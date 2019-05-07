import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestCart {

    private WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        for (int i = 1; i < 4; i++) {
            driver.get("http://localhost/litecart/en/");
            List<WebElement> goods = driver.findElements(By.cssSelector(".product"));
            goods.get(0).click();
            if (!driver.findElements(By.cssSelector(".options")).isEmpty()) {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByVisibleText("Small");
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        driver.findElement(By.xpath("//a[contains(.,'Checkout »')]")).click();
        List<WebElement> goodsInCart = driver.findElements(By.cssSelector(".shortcut"));
        for(int i = goodsInCart.size(); i > 0; i--){
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(goodsInCart.get(0)));
        }
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}