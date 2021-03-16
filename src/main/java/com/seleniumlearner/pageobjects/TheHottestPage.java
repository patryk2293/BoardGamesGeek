package com.seleniumlearner.pageobjects;

import com.seleniumlearner.helpers.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TheHottestPage extends BasePage {

    public TheHottestPage(WebDriver driver){
        super(driver);
    }

    private By theGamesThumbnailsLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//li[@class='hotness-item ng-scope has-image']");
    private By buttonWithOptionsHottnesLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//button[@uib-tooltip='Display options']");
    private By listHottestDisplayLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//button[@class='btn btn-empty']");
    private By listInHottestRankLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//div[@class='hotness-item-body']");
    private By dropDownHottesButtonLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//span[@class='dropdown']");
    private By listTypeHottestLocator = By.xpath("//div[@class='global-body-content-container container-fluid']//button[@class='btn btn-empty ng-binding']");


    public TheHottestPage goToUrl() {
        driver.navigate().to("https://boardgamegeek.com/browse/boardgame");
        wait.until(ExpectedConditions.titleIs("Browse Board Games | BoardGameGeek"));
        return this;
    }

    public int checkCountGamesInTheHottnes(){
        return wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(theGamesThumbnailsLocator))).size();
    }

    public void selectFromDropDownHottnesDisplay(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonWithOptionsHottnesLocator)).click();
        CommonMethods.selectFromDropDownByText(driver.findElements(listHottestDisplayLocator),text);
    }

    public int checkCountInTheHottnesRank(){
        return driver.findElements(listInHottestRankLocator).size();
    }

    public void selectFromDropDownType(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownHottesButtonLocator)).click();
        CommonMethods.selectFromDropDownByText(driver.findElements(listTypeHottestLocator),text);
    }

}
