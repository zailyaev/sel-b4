import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Comparator;
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
        for (int a = 0; a < zone; a++) {
            driver.findElements(By.cssSelector(".dataTable .row"))
                    .get(a).findElement(By.cssSelector(".fa-pencil")).click();
            int zoneCode = driver.findElements(By.xpath("(//select[contains(@name,'zone_code]')])")).size();
            List<String> zones = new ArrayList<String>();
            for (int b = 0; b < zoneCode; b++) {
                List<WebElement> options = driver.findElements(By.xpath("(//select[contains(@name,'zone_code]')])"))
                        .get(b).findElements(By.cssSelector("option"));
                for (WebElement option : options) {
                    if ("true".equals(option.getAttribute("selected"))) {
                        String optionText = option.getText();
                        zones.add(optionText);
                    }
                }
                List<String> sortedZoneList = zones;
                sortedZoneList.sort(Comparator.naturalOrder());
                Assert.assertEquals(zones, sortedZoneList);
            }
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
