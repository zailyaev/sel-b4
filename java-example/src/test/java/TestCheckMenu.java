import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCheckMenu {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        int menu = driver.findElements(By.id("app-")).size();
        for ( int i = 0; i < menu; i++){
            driver.findElements(By.id("app-")).get(i).click();
            int submenu = driver.findElements(By.cssSelector("#app- ul a")).size();
            for (int l = 0; l < submenu; l++){
                driver.findElements(By.cssSelector("#app- ul a")).get(l).click();
                driver.findElement(By.cssSelector("h1"));
            }
        }
    }
    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}