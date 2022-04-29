package tests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.DSL;




public class MainPage extends DSL {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage checkForUrlContains(String keyword) throws Exception {

        Thread.sleep(6000);
        Assert.assertTrue(driver.getCurrentUrl().contains(keyword));
        return this;
    }

    public MainPage moveToMagazalar(){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//span[@title='Mağazalar'])"))).perform();

    return this;
    }

    public MainPage locationOk(){
        click(By.xpath("(//div[@id='myLocation-close-info'])"));

        return this;
    }

    public MainPage seeToMagazalarButon(){
        click(By.xpath("(//a[@title='Mağazaları Gör'])"));

        return this;
    }
    public MainPage popUpDahaSonra(){
        click(By.xpath("(//button[@class='dn-slide-deny-btn'])[1]"));
        return this;
}

    public MainPage searchBox(String arg0){
        driver.findElement(By.xpath("(//input[@id='searchData'])")).sendKeys(arg0+Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='resultText '])")).getText().contains(arg0));
        return this;
}


}
