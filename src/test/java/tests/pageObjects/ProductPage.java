package tests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.DSL;

import java.util.List;

public class ProductPage extends DSL {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public ProductPage smartList(String value){
        Select sorted=new Select(driver.findElement(By.id("sortingType")));
        sorted.selectByValue(value);
        return this;
    }

    public ProductPage freeKargo(){
        By optoin = By.xpath("(//input[@id='freeShippingOption'])");
        click(optoin);
        return this;
    }


public ProductPage listOfProductResult() throws InterruptedException {
    List<WebElement> listOfResult = driver.findElements(By.xpath("(//h3[@class='productName'])"));
    click(By.xpath("(//h3[@class='productName'])[1]"));
    Thread.sleep(3000);

    click(By.xpath("(//button[@title='Sepete Ekle'])"));
    Thread.sleep(3000);
    WebElement sepeteBasariliEklemePopup=driver.findElement(By.cssSelector(".myBasketHolder strong"));
    Assert.assertTrue("Sepete ekleme-1 basarisiz",sepeteBasariliEklemePopup.isDisplayed());

    driver.navigate().back();
    Thread.sleep(3000);
    click(By.xpath("(//h3[@class='productName'])[last()]"));
    Thread.sleep(3000);
    click(By.xpath("(//button[@title='Sepete Ekle'])"));

        return this;
}

}
