import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStickers {

    private WebDriver driver = new ChromeDriver();

    @Test
    public void test() {

        driver.manage().window().maximize();
        driver.navigate().to("http://localhost/litecart/en/");
        driver.findElement(By.xpath("(//div[@class='name'][contains(.,'Duck')])"));
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}