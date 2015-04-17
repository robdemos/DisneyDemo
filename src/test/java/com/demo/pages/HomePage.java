package com.demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage {
    //add more elements and methods to operate on them as needed

    @FindBy(name = "Searchstr")
    private WebElement searchInput;


    @FindBy(name = "rfk_products")
    private List<WebElement> products;


    @FindBy(name = "rfk_product")
    private WebElement product;


    public void searchForProduct(String searchStr) throws Exception{
        searchInput.sendKeys(searchStr);
        searchInput.sendKeys(Keys.ENTER);

        //Yes this sleep is evil and wrong, but don't have .js hooks on the page
        Thread.sleep(3000);
    }

}
