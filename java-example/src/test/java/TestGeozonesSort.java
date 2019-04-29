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

public class TestGeozonesSort {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int zone = driver.findElements(By.cssSelector(".dataTable .row")).size();
        for (int a = 0; a < zone; a++){
            driver.findElements(By.cssSelector(".dataTable .row"))
                    .get(a).findElement(By.cssSelector(".fa-pencil")).click();
            List<String> zones = new ArrayList<String>();
            getZonesList(zones);
            boolean sorted = Ordering.natural().isOrdered(zones);
            Assert.assertTrue(sorted);
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    private void getZonesList(List<String> zones) {
        int zoneCode = driver.findElements(By.xpath("(//select[contains(@name,'zone_code]')])")).size();
        for (int b = 0; b < zoneCode; b++){
            int count = driver.findElements(By.xpath("(//select[contains(@name,'zone_code]')])"))
                    .get(b).findElements(By.cssSelector("option")).size();
        }
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
