import com.google.common.collect.Ordering;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCountriesZonesSort {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int s = driver.findElements(By.cssSelector(".row")).size();
        for (int i = 0; i < s; i++) {
            String quantity = driver.findElements(By.cssSelector(".row"))
                    .get(i).findElement(By.xpath("./td[6]")).getText();
            if (!quantity.equals("0")) {
                driver.findElements(By.cssSelector(".row"))
                        .get(i).findElement(By.cssSelector(".fa-pencil")).click();
                List<String> zones = getList();
                boolean sorted = Ordering.natural().isOrdered(zones);
                Assert.assertTrue(sorted);
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
    }

    private List<String> getList() {
        int count = driver.findElement(By.id("table-zones"))
                .findElements(By.cssSelector("tr:not(.header)")).size() - 1;
        List<String> zones = new ArrayList<String>();
        for (int l = 0; l < count; l++){
            zones.add(driver.findElements(By.cssSelector("#table-zones tr:not(.header)"))
                    .get(l).findElement(By.xpath("./td[3]")).getText());
        }
        return zones;
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
