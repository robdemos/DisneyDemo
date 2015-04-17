package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage {
    //add more elements and methods to operate on them as needed

    @FindAll({@FindBy(className = "productTile")})
    private List<WebElement> productList;
    

    public void chooseProduct(String productDescription) throws Exception{
        for(WebElement product : productList) {
            String pTileDescription = product.findElement(By.tagName("h3")).getText();
            if(pTileDescription.equals(productDescription)) {
                product.click();
                break;
            }

        }
    }
}
