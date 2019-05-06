import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestUserRegistration {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test ()  {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
        String email = "email" + System.currentTimeMillis() + "@yopmail.com";
        String password = "pass";
        createUser(email, password);
        logout();
        login(email, password);
        logout();
    }

    private void createUser(String email, String password) {
        driver.findElement(By.cssSelector("#box-account-login a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Donald");
        driver.findElement(By.name("lastname")).sendKeys("Duck");
        driver.findElement(By.name("address1")).sendKeys("Disneyland");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("Anaheim");
        driver.findElement(By.cssSelector(".select2-selection__arrow")).click();
        driver.findElement(By.xpath("(//li[contains(.,'United States')])[1]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+11111111111111");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.cssSelector("select[name='zone_code'] option[value='TX']")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();
    }

    private void logout() {
        driver.findElement(By.xpath("(//a[contains(.,'Logout')])[1]")).click();
    }

    private void login(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}