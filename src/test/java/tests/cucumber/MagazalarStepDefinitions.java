package tests.cucumber;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests.pageObjects.MagazalarPage;
import utilities.Driver;

import java.io.IOException;

public class MagazalarStepDefinitions  {
    MagazalarPage magazalarPage=new MagazalarPage(Driver.get());

    @Then("^I click the Tüm Magazalar button\\.$")
    public void iClickTheTümMagazalarButton() {
        magazalarPage.clickTumMagazalar();
    }

    @And("I print the Tüm Magazalar in the letter A.")
    public void iPrintTheTümMagazalarInTheLetterA() throws IOException {
    magazalarPage.beginLetterAMagaza();
    }


}
