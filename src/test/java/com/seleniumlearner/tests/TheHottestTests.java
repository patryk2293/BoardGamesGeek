package com.seleniumlearner.tests;

import com.seleniumlearner.pageobjects.TheHottestPage;
import org.junit.Assert;
import org.junit.Test;

public class TheHottestTests extends BaseTest {
    int gamesInThumbnails = 15;
    int rankHottestList = 30;

    @Test
    public void countGames() {
        TheHottestPage theHottestPage = new TheHottestPage(driver);
        int actualCountGames = theHottestPage.goToUrl()
                .checkCountGamesInTheHottnes();

        Assert.assertEquals("Count is not equal: " + gamesInThumbnails, gamesInThumbnails, actualCountGames);
    }

    @Test
    public void countGamesInList() {
        TheHottestPage theHottestPage = new TheHottestPage(driver);
        theHottestPage.goToUrl()
                .selectFromDropDownHottnesDisplay("List");
        int actualCountRank = theHottestPage.checkCountInTheHottnesRank();

        Assert.assertEquals("Count is not equal: " + rankHottestList, rankHottestList, actualCountRank);
    }

    @Test
    public void countCompaniesInList() {
        TheHottestPage theHottestPage = new TheHottestPage(driver);
        String type = "Companies";
        theHottestPage.goToUrl()
                .selectFromDropDownType(type);
        int actualCountRank = theHottestPage.checkCountInTheHottnesRank();

        Assert.assertEquals("Count is not equal: " + rankHottestList, rankHottestList, actualCountRank);
    }

    @Test
    public void countPeopleInList() {
        TheHottestPage theHottestPage = new TheHottestPage(driver);
        String type = "People";
        theHottestPage.goToUrl()
                .selectFromDropDownType(type);
        int actualCountRank = theHottestPage.checkCountInTheHottnesRank();

        Assert.assertEquals("Count is not equal: " + rankHottestList, rankHottestList, actualCountRank);
    }

}
