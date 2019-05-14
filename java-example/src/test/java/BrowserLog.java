import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserLog {
    private WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }
    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> goods = driver.findElements(By.xpath("//td /a[contains(.,'Duck')]"));
        int goodsQuantity = goods.size();
        for(int i = 0; i < goodsQuantity; i++){
            goods.get(i).click();
            System.out.println(driver.manage().logs().getAvailableLogTypes());
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
            List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
            assert logs.isEmpty();
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            goods = driver.findElements(By.xpath("//td /a[contains(.,'Duck')]"));
        }
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}