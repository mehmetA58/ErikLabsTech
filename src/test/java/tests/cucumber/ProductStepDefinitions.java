package tests.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests.pageObjects.ProductPage;
import utilities.Driver;

public class ProductStepDefinitions {

    ProductPage productPage=new ProductPage(Driver.get());



    @And("I sorted the results according to {string}")
    public void iSortedTheResultsAccordingTo(String arg0) {
        productPage.smartList(arg0);
    }


    @And("I listed the products with Free Kargo")
    public void iListedTheProductsWithFreeKargo() {
        productPage.freeKargo();
    }

    @Then("I added the first and last product to the cart.")
    public void iAddedTheFirstAndLastProductToTheCart() throws InterruptedException {
        productPage.listOfProductResult();
    }
}
