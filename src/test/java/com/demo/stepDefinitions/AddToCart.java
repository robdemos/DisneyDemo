package com.demo.stepDefinitions;

import com.demo.pages.HomePage;
import com.demo.pages.ProductDetailPage;
import com.demo.pages.SearchResultsPage;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class AddToCart {
    //These strings could be added to a props file or maybe in cucumber
    private String url = "http://www.disneystore.com";
    private String productDescription = "Mickey Mouse Ear Hat for Adults - Walt Disney World";
    private String searchStr = "Mickey Mouse Hat";

    //Prepare Page Models and driver
    private ChromeDriver driver = new ChromeDriver();
    private HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    private SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
    private ProductDetailPage productDetailPage = PageFactory.initElements(driver, ProductDetailPage.class);

    @After
    public void killDriver() {
        driver.quit();
    }


    @Given("^A user visits the disney store$")
    public void A_user_visits_the_disney_store() throws Throwable {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }


    @And("^searches for a mickey mouse hat$")
    public void searches_for_a_mickey_mouse_hat() throws Throwable {
        homePage.searchForProduct(searchStr);
    }


    @And("^adds one to the cart$")
    public void adds_one_to_the_cart() throws Throwable {
        searchResultsPage.chooseProduct(productDescription);
        productDetailPage.addToCart();
    }


    @Then("^the hat should be the only item in the cart$")
    public void the_hat_should_be_the_only_item_in_the_cart() throws Throwable {
        List<String> items = productDetailPage.getCartedItems();

        //check there is only one item in the cart
        assertTrue(items.size() == 1);
        assertEquals(items.get(0), productDescription);
    }
}
