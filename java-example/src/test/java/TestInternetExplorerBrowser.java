import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestInternetExplorerBrowser {

    private WebDriver driver = new InternetExplorerDriver();

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("#box-widgets")).isDisplayed();
    }

    @After
    public void stopDriver() {

        driver.quit();
    }
}

