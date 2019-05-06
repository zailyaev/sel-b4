import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestAddNewProduct {
    private WebDriver driver;

    @Before
    public void start () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[contains(.,'Catalog')]")).click();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.xpath("//input[@name='status'][@value=1]")).click();
        driver.findElement(By.name("name[en]")).sendKeys("Darth Vader Duck");
        driver.findElement(By.name("code")).sendKeys("DVD001");
        driver.findElement(By.xpath("//input[@value='1-3']")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("100");
        File file = new File("D:/TestProjects/java-example/src/test/pictures/darth-vader-duck.jpg");
        driver.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.name("date_valid_from")).sendKeys("01012019");
        driver.findElement(By.name("date_valid_to")).sendKeys("01012020");
        driver.findElement(By.linkText("Information")).click();
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.cssSelector("select[name='manufacturer_id'] option[value='1']")).click();
        driver.findElement(By.name("keywords")).sendKeys("duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("new duck");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("A long time ago in a galaxy far, far away.");
        driver.findElement(By.name("head_title[en]")).sendKeys("head title");
        driver.findElement(By.name("meta_description[en]")).sendKeys("meta description");
        driver.findElement(By.linkText("Prices")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("100");
        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.cssSelector("select[name='purchase_price_currency_code'] option[value='USD']")).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("100");
        driver.findElement(By.name("prices[EUR]")).sendKeys("89");
        driver.findElement(By.name("save")).click();
        driver.findElement(By.linkText("Darth Vader Duck")).click();
        driver.findElement(By.name("delete")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Rubber Ducks")).isDisplayed(); //выглядит, как лишняя строка, но без нее не отрабатывает подтверждение удаления
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}