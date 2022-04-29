package tests.cucumber;

import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hook {

    @Before
    public void setup(){
        System.out.println("#####################");
        System.out.println("Test setup!");
        Driver.get().manage().window().maximize();
    }
    @After
    public void teardown(Scenario scenario){

        if(scenario.isFailed()){
            System.out.println("Test failed!");
            byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");

        }else{
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        System.out.println("##############################");

        Driver.close();

    }
}