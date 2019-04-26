import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestStickers {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void testStickerCheck() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
        int ducks = driver.findElements(By.cssSelector(".product")).size();
        for (int i = 0; i < ducks; i++){
            Assert.assertEquals(driver.findElements(By.cssSelector(".product")).get(i)
                    .findElements(By.cssSelector(".sticker")).size(),1);
        }
    }
    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}