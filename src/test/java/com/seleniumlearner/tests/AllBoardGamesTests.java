package com.seleniumlearner.tests;

import com.seleniumlearner.pageobjects.AllBoardGamesPage;
import org.junit.Assert;
import org.junit.Test;

public class AllBoardGamesTests extends BaseTest {

    private Boolean actualSort;

    @Test
    public void reversedRank() {
        AllBoardGamesPage allBoardGamesPage = new AllBoardGamesPage(driver);
        actualSort = allBoardGamesPage
                .goToUrl()
                .sortByRank()
                .checkReversedRank();

        Assert.assertEquals("List is not reversed", true, actualSort);
    }

    @Test
    public void reversedTitle() {
        AllBoardGamesPage allBoardGamesPage = new AllBoardGamesPage(driver);
        actualSort = allBoardGamesPage
                .goToUrl()
                .checkReversedTitle();

        Assert.assertEquals("List is not reversed", true, actualSort);
    }

    @Test
    public void reversedGeekRating() {
        AllBoardGamesPage allBoardGamesPage = new AllBoardGamesPage(driver);
        actualSort = allBoardGamesPage
                .goToUrl()
                .checkReversedGeekRating();

        Assert.assertEquals("List is not reversed", true, actualSort);
    }

    @Test
    public void reversedAVGRating() {
        AllBoardGamesPage allBoardGamesPage = new AllBoardGamesPage(driver);
        actualSort = allBoardGamesPage
                .goToUrl()
                .checkReversedAvgRating();

        Assert.assertEquals("List is not reversed", true, actualSort);
    }

    @Test
    public void reversedNumVoters() {
        AllBoardGamesPage allBoardGamesPage = new AllBoardGamesPage(driver);
        actualSort = allBoardGamesPage
                .goToUrl()
                .checkReversedNumVoter();

        Assert.assertEquals("List is not reversed", true, actualSort);
    }
}
