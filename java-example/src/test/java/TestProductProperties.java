import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestProductProperties {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        // driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {

        driver.get("http://localhost/litecart/en/");
        String mainPageProductName = driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("innerText");
        String mainPageCommonPriceText = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("innerText");
        String mainPageCommonPriceColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        String[] mainPageCommonPriceColorSplit = mainPageCommonPriceColor.split(",");
        String mainPageCommonPriceStyle = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
        String mainPageCommonPriceFontSize = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size").replace("px", "");
        Double mainPageCommonPriceFontSizeDouble = Double.parseDouble(mainPageCommonPriceFontSize);
        String mainPageBargainPriceText = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("innerText");
        String mainPageBargainPriceColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        String[] mainPageBargainPriceColorSplit = mainPageBargainPriceColor.split(",");
        String mainPageBargainPriceStyle = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
        String mainPageBargainPriceFontSize = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size").replace("px", "");
        Double mainPageBargainPriceFontSizeDouble = Double.parseDouble(mainPageBargainPriceFontSize);

        driver.findElement(By.cssSelector("#box-campaigns .name")).click();
        String ownPageProductName = driver.findElement(By.cssSelector("h1.title")).getAttribute("innerText");
        String ownPageCommonPriceText = driver.findElement(By.cssSelector(".regular-price")).getAttribute("innerText");
        String ownPageCommonPriceColor = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String[] ownPageCommonPriceColorSplit = ownPageCommonPriceColor.split(",");
        String ownPageCommonPriceStyle = driver.findElement(By.cssSelector(".regular-price")).getTagName();
        String ownPageCommonPriceFontSize = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size").replace("px", "");
        Double ownPageCommonPriceFontSizeDouble = Double.parseDouble(ownPageCommonPriceFontSize);
        String ownPageBargainPriceText = driver.findElement(By.cssSelector(".campaign-price")).getAttribute("innerText");
        String ownPageBargainPriceColor = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String[] ownPageBargainPriceColorSplit = ownPageBargainPriceColor.split(",");
        String ownPageBargainPriceStyle = driver.findElement(By.cssSelector(".campaign-price")).getTagName();
        String ownPageBargainPriceFontSize = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size").replace("px", "");
        Double ownPageBargainPriceFontSizeDouble = Double.parseDouble(ownPageBargainPriceFontSize);

        Assert.assertEquals(mainPageProductName, ownPageProductName);
        Assert.assertEquals(mainPageCommonPriceText, ownPageCommonPriceText);
        Assert.assertEquals(mainPageBargainPriceText, ownPageBargainPriceText);
        Assert.assertEquals(mainPageCommonPriceColorSplit[0], mainPageCommonPriceColorSplit[1], mainPageCommonPriceColorSplit[2]);
        Assert.assertEquals(mainPageCommonPriceStyle, "s");
        Assert.assertEquals(mainPageBargainPriceColorSplit[1], mainPageBargainPriceColorSplit[2], " 0");
        Assert.assertEquals(mainPageBargainPriceStyle, "strong");
        assert (mainPageCommonPriceFontSizeDouble < mainPageBargainPriceFontSizeDouble);
        Assert.assertEquals(ownPageCommonPriceColorSplit[0], ownPageCommonPriceColorSplit[1], ownPageCommonPriceColorSplit[2]);
        Assert.assertEquals(ownPageCommonPriceStyle, "s");
        Assert.assertEquals(ownPageBargainPriceColorSplit[1], ownPageBargainPriceColorSplit[2], " 0");
        Assert.assertEquals(ownPageBargainPriceStyle, "strong");
        assert (ownPageCommonPriceFontSizeDouble < ownPageBargainPriceFontSizeDouble);

        System.out.println("Name: "+mainPageProductName + " = " + ownPageProductName);
        System.out.println("-------------------------");
        System.out.println("CommonPrice: "+mainPageCommonPriceText + " = " + ownPageCommonPriceText);
        System.out.println("-------------------------");
        System.out.println("CommonPriceColor: "+mainPageCommonPriceColorSplit[0]+mainPageCommonPriceColorSplit[1]+mainPageCommonPriceColorSplit[1]+")"+" / "+ownPageCommonPriceColorSplit[0]+ownPageCommonPriceColorSplit[1]+ownPageCommonPriceColorSplit[1]+")");
        System.out.println("-------------------------");
        System.out.println("CommonPriceStyle: "+mainPageCommonPriceStyle + " = "+ownPageCommonPriceStyle);
        System.out.println("-------------------------");
        System.out.println("CommonPriceFontSize: "+mainPageCommonPriceFontSizeDouble + " / "+ownPageCommonPriceFontSizeDouble);
        System.out.println("-------------------------");
        System.out.println("BargainPrice: "+mainPageBargainPriceText + " = " + ownPageBargainPriceText);
        System.out.println("-------------------------");
        System.out.println("BargainPriceColor: "+mainPageBargainPriceColorSplit[0]+mainPageBargainPriceColorSplit[1]+mainPageBargainPriceColorSplit[1]+")"+" / "+ownPageBargainPriceColorSplit[0]+ownPageBargainPriceColorSplit[1]+ownPageBargainPriceColorSplit[1]+")");
        System.out.println("-------------------------");
        System.out.println("BargainPriceStyle: "+mainPageBargainPriceStyle+" = "+ownPageBargainPriceStyle);
        System.out.println("-------------------------");
        System.out.println("BargainPriceFontSize: "+mainPageBargainPriceFontSizeDouble + " / "+ownPageBargainPriceFontSizeDouble);
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}