package tests.cucumber;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.pageObjects.MainPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;


public class MainStepDefinitions  {

     MainPage mainPage=new MainPage(Driver.get());




    @Given("^I am on the ENONBİR site$")
    public void iAmOnTheENONBİRSite() {
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }


    @Then("^I'm verifying the \"([^\"]*)\"$")
    public void iMVerifyingThe(String URL) throws Throwable {
     mainPage.checkForUrlContains(URL);
     Thread.sleep(3000);
        mainPage.locationOk();
        mainPage.popUpDahaSonra();
    }


    @When("^I'm move to Magazalar$")
    public void iMMoveToMagazalar() throws InterruptedException {
        mainPage.moveToMagazalar();
    }

    @And("^I select MagazalarıGör$")
    public void iSelectMagazalarıGör() {
        mainPage.seeToMagazalarButon();
    }


    @Then("I am searching {string}")
    public void iAmSearching(String arg0) {
    mainPage.searchBox(arg0);
    BrowserUtils.waitForPageToLoad(3);

    }

    @And("I closed the pages")
    public void iClosedThePages() {
        Driver.close();
    }
}
