package tests.pageObjects;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        return this;
    }

    public MagazalarPage beginLetterAMagaza() throws IOException {
        List<WebElement> magaza = Driver.get().findElements(By.xpath("(//div[@class='sellerListHolder'])[4]//ul"));
        File file = new File("C:\\Users\\pc1\\Desktop\\TestData.xls");


        FileInputStream inputStream = new FileInputStream(file);


        HSSFWorkbook wb = new HSSFWorkbook(inputStream);


        HSSFSheet sheet = wb.getSheet("Letter A");


        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        for (int i = 1; i <= magaza.size(); i++) {


            HSSFCell cell = sheet.getRow(i).createCell(0);

            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\pc1\\Desktop\\TestData.xls");
            wb.write(outputStream);
        }
        wb.close();
        return this;
    }

}

