package tests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DSL;
import utilities.Driver;

import java.io.*;
import java.util.List;

public class MagazalarPage extends DSL {


    public MagazalarPage(WebDriver driver) {
        super(driver);
    }

    public MagazalarPage clickTumMagazalar() {
        click(By.xpath("(//div[@class='tabList'])//ul//li[4]//div//h3"));
        String tumMgazalarTitle=driver.findElement(By.xpath("(//div[@id='contentSellerList']/div/div[2]/div/div[2]/div[4]/h2)")).getText();
        String AileBas=driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//span//i")).getText();
        Assert.assertTrue("Tüm Magazalar Title görüntülenemedi",tumMgazalarTitle.contains("Tüm Mağazalar"));
        Assert.assertTrue("Aile baslayan Magazalar Görüntülenemedi",AileBas.contains("A"));
        return this;
    }

    public MagazalarPage beginLetterAMagaza() throws IOException {
        List<WebElement> magaza = Driver.get().findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//ul"));

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")));

        Writer writer = null;


        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("ErikLabs .txt"), "utf-8"));
            writer.write("N11 A ile başlayan Mağazalar : " + driver.findElement(By.xpath("(//div[@class='sellerListHolder'])[4]//ul")).getText());

        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
        return this;
    }

}

