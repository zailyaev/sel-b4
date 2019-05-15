import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageMain extends PageBase {

    @FindBy(xpath="//li[@class = 'product column shadow hover-light']")
    public List<WebElement> items;

    public PageMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/en/");
    }
}