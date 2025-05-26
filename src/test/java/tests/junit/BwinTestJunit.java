package tests.junit;

import core.BwinWebApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BwinTestJunit {
    public BwinWebApplication bwinWebApplication = new BwinWebApplication();

    @BeforeEach
    public void init(){
        bwinWebApplication.browser().initChrome();
    }

    @Test
    public void addingPickToBetslip() throws InterruptedException {
        //Open Main page
        bwinWebApplication.mainPage().openMainPage();

        //Accept Cookies
        bwinWebApplication.mainPage().acceptCookies();

        //Click EventView
        bwinWebApplication.mainPage().clickEventView();

        //Choos betslip
        bwinWebApplication.mainPage().clickFirstBetSlip();

        //Check if betslip is highlited
        boolean isHighlighted = bwinWebApplication.mainPage().isBetslipelementHighlighted();
        Assertions.assertTrue(isHighlighted, "Element should be highlighted");

        // Compare betslips
        String firstBetSlipAmount = bwinWebApplication.mainPage().getFirstBetSlipAmount();
        String betSlipPickOdds = bwinWebApplication.mainPage().getBetSlipPickOdds();
        Assertions.assertEquals(firstBetSlipAmount, betSlipPickOdds);
    }

    @Test
    public void vavalidateLiveOddsUpdates() throws InterruptedException {
        //Open Main page
        bwinWebApplication.mainPage().openMainPage();

        //Accept Cookies
        bwinWebApplication.mainPage().acceptCookies();

        //Click EventView
        bwinWebApplication.tableTennis().clickTableTennis();

        //Check for updating odds - player one
        bwinWebApplication.tableTennis().checkUpdateOddsPlayerOne();

        //Check for color update - player two
        bwinWebApplication.tableTennis().checkUpdateColorsIndicatorPlayerTwo();
    }

    @Test
    public void vavalidateAZSports() throws InterruptedException {
        //Open Main page
        bwinWebApplication.mainPage().openMainPage();

        //Accept Cookies
        bwinWebApplication.mainPage().acceptCookies();

        //Click EventView
        bwinWebApplication.mainPage().clickAZSportMenu();

        //Choose Table Tennis from the AZ sports menu
        bwinWebApplication.tableTennis().clickTableTennisAZSport();

        //Check if Table Tennis is Highlighted
        boolean isHighlighted = bwinWebApplication.tableTennis().isTableTennisHighlighted();
        Assertions.assertTrue(isHighlighted, "Table Tennis tab MUST be highlighted!!!");

        //Check current url
        bwinWebApplication.tableTennis().assertTableTennisSportPageLoaded();
    }

    @AfterEach
    public void tearDown(){
        bwinWebApplication.browser().tearDown();
    }

}