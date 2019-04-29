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

public class TestCountriesSort {
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

        List<String> countries = getList();
        boolean sorted = Ordering.natural().isOrdered(countries);
        Assert.assertTrue(sorted);
    }

    private List<String> getList() {
        List<String> countries = new ArrayList<String>();
        int row = driver.findElements(By.cssSelector(".row")).size();
        for (int i = 0; i < row; i++) {
            countries.add(driver.findElements(By.cssSelector(".row"))
                    .get(i).findElement(By.xpath(".//a")).getText());
        }
        return countries;
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}
