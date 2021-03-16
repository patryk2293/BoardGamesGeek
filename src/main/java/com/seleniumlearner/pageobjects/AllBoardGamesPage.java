package com.seleniumlearner.pageobjects;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AllBoardGamesPage extends BasePage {

    public AllBoardGamesPage(WebDriver driver) {
        super(driver);
    }

    private By rankRowsLocator = By.xpath("//table/tbody/tr/td[1]");
    private By titleRowsLocator = By.xpath("//table/tbody/tr/td[3]/div/a");
    private By geekRatingRowsLocator = By.xpath("//table/tbody/tr/td[4]");
    private By avgRatingRowsLocator = By.xpath("//table/tbody/tr/td[5]");
    private By numVoterRowsLocator = By.xpath("//table/tbody/tr/td[6]");

    private By rankButtonLocator = By.xpath("//table/tbody/tr/th[1]");
    private By titleButtonLocator = By.xpath("//table/tbody/tr/th[3]");
    private By geekRatingButtonLocator = By.xpath("//table/tbody/tr/th[4]");
    private By avgRatingButtonLocator = By.xpath("//table/tbody/tr/th[5]");
    private By numVoterButtonLocator = By.xpath("//table/tbody/tr/th[6]");

    private By nextPageLocator = By.xpath("//div[@class='infobox']//a[@title='next page']");


    public AllBoardGamesPage goToUrl() {
        driver.navigate().to("https://boardgamegeek.com/browse/boardgame");
        wait.until(ExpectedConditions.titleIs("Browse Board Games | BoardGameGeek"));
        return this;
    }


    public AllBoardGamesPage sortByRank() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(rankButtonLocator));
        driver.findElement(rankButtonLocator).click();
        return this;
    }

    public Boolean checkReversedRank() {
        return isReversed(rankButtonLocator, rankRowsLocator, nextPageLocator);
    }

    public Boolean checkReversedTitle() {
        return isReversed(titleButtonLocator, titleRowsLocator, nextPageLocator);
    }

    public boolean checkReversedGeekRating() {
        return isReversed(geekRatingButtonLocator, geekRatingRowsLocator, nextPageLocator);
    }

    public boolean checkReversedAvgRating() {
        return isReversed(avgRatingButtonLocator, avgRatingRowsLocator, nextPageLocator);
    }

    public boolean checkReversedNumVoter() {
        return isReversed(numVoterButtonLocator, numVoterRowsLocator, nextPageLocator);
    }

    public boolean isReversed(By locatorButton, By rowsLocator, By nextPageLocator) {
        List<String> sortedStrings = new ArrayList<String>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorButton));
        driver.findElement(locatorButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(locatorButton));
        driver.findElement(locatorButton).click();
        for (int i = 0; i < 5; i++) {
            wait.until(ExpectedConditions.titleIs("Browse Board Games | BoardGameGeek"));
            for (WebElement element : driver.findElements(rowsLocator)) {
                sortedStrings.add(element.getText());
            }
            driver.findElement(nextPageLocator).click();
        }
        System.out.println(sortedStrings);
        return Ordering.natural().reverse().isOrdered(sortedStrings);
    }
}