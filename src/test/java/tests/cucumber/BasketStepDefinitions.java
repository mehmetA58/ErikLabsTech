package tests.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tests.pageObjects.BasketPage;
import utilities.Driver;

import java.text.ParseException;

public class BasketStepDefinitions {
    BasketPage basketPage=new BasketPage(Driver.get());

    @And("I'm in the basket")
    public void iMInTheBasket() throws InterruptedException {
        basketPage.goToBasket();
        Thread.sleep(2000);
        basketPage.kvvkTamam();

    }



    @Then("I made two for the cheapest of the products.")
    public void iMadeTwoForTheCheapestOfTheProducts() throws ParseException, InterruptedException {
        basketPage.productPrice();
    }

    @And("I proceeded to the checkout step as a guest user")
    public void iProceededToTheCheckoutStepAsAGuestUser() throws InterruptedException {
    basketPage.odemeyeGec();
    Thread.sleep(2000);
    basketPage.uyeOlmadanDevamEt();
        Assert.assertTrue("Uye olmadan devam edemedi",Driver.get().getCurrentUrl().contains("https://www.n11.com/misafir-sepet") );

    }
}
