package pages;

import base.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.junit.jupiter.api.Assertions;

public class TableTennis extends BaseTools {

    public TableTennis(WebDriver driver) {
        super(driver);
    }

    //WebElements-------------------------

    @FindBy(how = How.XPATH, using = "//*[@id=\"ds-tab-id-2-56\"]/div/a/span")
    public WebElement tableTennis;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main-view\"]/ms-live/div[1]/ms-live-event-list/div/ms-grid/div/ms-event-group/ms-event[2]/div/div/ms-option-group[1]/ms-option[1]/ms-event-pick/div")
    public WebElement initialOddPlayerOne;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main-view\"]/ms-live/div[1]/ms-live-event-list/div/ms-grid/div/ms-event-group/ms-event[2]/div/div/ms-option-group[1]/ms-option[2]/ms-event-pick/div")
    public WebElement initialOddPlayerTwo;

    @FindBy(how = How.XPATH, using = "//ds-list-item[contains(.,'Table Tennis')]")
    public WebElement AZSportTableTennis;

    @FindBy(how = How.XPATH, using = "//vn-menu-item[contains(.,'Table Tennis')]")
    public WebElement menuTableTennis;

    @FindBy(how = How.XPATH, using = "//span[text()='A-Z Sports']")
    public WebElement AZSportsMenu;


    //Methods--------------------------------
    public void clickTableTennis(){
        waitForElementVisibility(tableTennis);
        LOGGER.info("Click Table Tennis");
        mouseOver(tableTennis);
        tableTennis.click();
    }

    public void checkUpdateOddsPlayerOne() throws InterruptedException {
        checkUpdateOdds(initialOddPlayerOne);
    }

    public void checkUpdateOddsPlayerTwo() throws InterruptedException {
        checkUpdateOdds(initialOddPlayerTwo);
    }

    public void checkUpdateColorsIndicatorPlayerOne() throws InterruptedException {
        checkUpdateColorsIndicator(initialOddPlayerOne);
    }

    public void checkUpdateColorsIndicatorPlayerTwo() throws InterruptedException {
        checkUpdateColorsIndicator(initialOddPlayerTwo);
    }

    public void clickTableTennisAZSport() throws InterruptedException {
        waitForElementVisibility(AZSportTableTennis);
        LOGGER.info("Click Table Tennis AZ Sport");
        mouseOver(AZSportTableTennis);
        AZSportTableTennis.click();
    }

    public boolean isTableTennisHighlighted() throws InterruptedException {
        return isElementHighlighted(menuTableTennis);
    }

    public void assertTableTennisSportPageLoaded() throws InterruptedException {
        assertSportPageLoaded("Table-Tennis");
    }










//    public String getTotalNmber(){
//        waitForElementVisibility(result);
//
//        String resulttext = result.getText();
//        String regex = "общо\\s(\\d+)";
//
//        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
//        java.util.regex.Matcher matcher = pattern.matcher(resulttext);
//
//        String resultNumber = null;
//
//        // Ensure there is a match before calling group()
//        if (matcher.find()) {
//            resultNumber = matcher.group(1);  // Get the number after "общо"
//            LOGGER.info("Total number of searched cars is: " + resultNumber);
//        } else {
//            LOGGER.warn("No number found after 'общо' in the result text.");
//        }
//
//        return resulttext;
//
//    }
//
//    public int countVipAdons(){
//        int size = promotedVipAds.size();
//        LOGGER.info("Total number of searched VIP adons is: " + size);
//        return size;
//    }
//
//    public int countTopAdons(){
//        int size = promotedTopAds.size();
//        LOGGER.info("Total number of searched TOP adons is: " + size);
//        return size;
//    }


}


