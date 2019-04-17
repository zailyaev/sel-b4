import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestSearchYandex {

    WebDriver driver = new ChromeDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    @Test
    public void testSearchYandex() {
        driver.navigate().to("http://www.ya.ru");
        driver.findElement(By.name("text")).sendKeys("Selenide");
        driver.findElement(By.cssSelector(".button_theme_websearch")).click();
        wait.until(titleIs("Selenide — Яндекс: нашлось 130 млн результатов"));
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}