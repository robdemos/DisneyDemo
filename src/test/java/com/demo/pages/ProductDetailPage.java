package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailPage {
    //add more elements and methods to operate on them as needed

    @FindBy(className = "productAdd")
    private WebElement productAddDiv;


    @FindBy(id = "ghBag")
    private WebElement bagDiv;


    @FindBy(className = "miniBagItem")
    private List<WebElement> cartItems;


    public void addToCart() throws Exception{
        //actual class= html attrib on page has compound name with spaces. Webdriver doesn't like that. Using nested tagname instead.
        productAddDiv.findElement(By.tagName("a")).click();

        //Yes this sleep is evil and wrong, but don't have .js hooks on the page
        Thread.sleep(5000);
    }


    //this method could be moved to a different class
    public List<String> getCartedItems() throws Exception{
        bagDiv.findElement(By.tagName("a")).click();

        //Yes this sleep is evil and wrong, but don't have .js hooks on the page
        Thread.sleep(5000);

        List<String> items = new ArrayList<String>();
        for(WebElement itemElement: cartItems) {
            WebElement header = itemElement.findElement(By.tagName("h4"));
            items.add(header.findElement(By.className("title")).getText());
        }
        return items;
    }

}
