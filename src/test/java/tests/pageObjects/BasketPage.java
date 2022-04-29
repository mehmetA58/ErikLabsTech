package tests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.DSL;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class BasketPage extends DSL {
    public BasketPage(WebDriver driver){
        super(driver);
    }
    public BasketPage goToBasket(){
        driver.navigate().to(ConfigurationReader.getProperty("urlSepetim"));
        return this;
    }

    public BasketPage kvvkTamam(){
        click(By.xpath("(//span[@class='btn btnBlack'])"));
        return this;
    }

    public BasketPage productPrice() throws ParseException, InterruptedException {
        WebElement product1= driver.findElement(By.xpath("(//div[@class='prodPrice__text'])[1]//input"));
        WebElement product2= driver.findElement(By.xpath("(//div[@class='prodPrice__text'])[2]//input"));

        String typeValue1=product1.getAttribute("value");
        String typeValue2=product2.getAttribute("value");

        WebElement adet1=driver.findElement(By.xpath("(//div[@class='spinnerField '])[1]//input"));
        WebElement adet2=driver.findElement(By.xpath("(//div[@class='spinnerField '])[2]//input"));

        String adetValue1=adet1.getAttribute("value");
        String adetValue2=adet2.getAttribute("value");



        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols sfs = new DecimalFormatSymbols();
        sfs.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(sfs);
        double d1 = df.parse(typeValue1).doubleValue();
        double d2 = df.parse(typeValue2).doubleValue();
        BrowserUtils.waitForPageToLoad(3);

        if (d1<d2){

           click(By.xpath("(//span[@class='spinnerUp spinnerArrow'])[1]"));
           Thread.sleep(3000);

        }else if (d1>d2){
            click(By.xpath("(//span[@class='spinnerUp spinnerArrow'])[2]"));
            Thread.sleep(3000);

        }
        Assert.assertTrue(adetValue1!=adetValue2);
        return this;
    }

    public BasketPage odemeyeGec(){
        click(By.xpath("(//span[@id='js-buyBtn'])"));
        return this;
    }
    public BasketPage uyeOlmadanDevamEt(){
        click(By.xpath("(//a[@class='btn-continue'])"));
        return this;
    }
}
