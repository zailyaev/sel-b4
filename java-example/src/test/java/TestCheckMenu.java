import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCheckMenu {

    private WebDriver driver = new ChromeDriver();

    @Test
    public void testLoginLitecart() {
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[contains(.,'Appearence')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Template')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-logotype")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Logotype')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Catalog')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Catalog')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-product_groups")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Product Groups')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-option_groups")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Option Groups')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-manufacturers")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Manufacturers')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-suppliers")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Suppliers')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Delivery Statuses')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-sold_out_statuses")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Sold Out Statuses')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-quantity_units")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Quantity Units')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-csv")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Countries')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Countries')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Currencies')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Currencies')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Customers')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Customers')]")).isDisplayed();
        driver.findElement(By.cssSelector(".selected #doc-csv")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Newsletter')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Newsletter')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Geo Zones')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Geo Zones')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Languages')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Languages')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Storage Encoding')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Storage Encoding')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Modules')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Job Modules')]")).isDisplayed();
        driver.findElement(By.cssSelector("#doc-customer")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Customer Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Shipping')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Shipping Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Payment')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Payment Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Order Total')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Total Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Order Success')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Success Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Order Action')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Action Modules')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Orders')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Orders')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Order Statuses')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Order Statuses')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Pages')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Pages')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Reports')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Monthly Sales')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Most Sold Products')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Most Sold Products')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Most Shopping Customers')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Most Shopping Customers')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Settings')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Defaults')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'General')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Listings')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Images')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Checkout')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Advanced')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Security')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Settings')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Slides')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Slides')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Tax')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Tax Classes')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Tax Rates')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Tax Rates')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Translations')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Search Translations')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Scan Files')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Scan Files For Translations')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'CSV Import/Export')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'CSV Import/Export')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'Users')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'Users')]")).isDisplayed();
        driver.findElement(By.xpath("//a[contains(.,'vQmods')]")).click();
        driver.findElement(By.xpath("//h1[contains(.,'vQmods')]")).isDisplayed();
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}