package pages;

import base.BaseTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BaseTools {

    public MainPage(WebDriver driver) {

        super(driver);
    }

    // Elements
    @FindBy(how = How.XPATH, using = "(//ul[@role='tablist']//li)[2]")
    public WebElement eventView;

    @FindBy(how = How.XPATH, using = "(//span[@class='result-odds'])[1]")
    public WebElement firstBetSlip;

    @FindBy(how = How.XPATH, using = "(//div[@class='option-indicator selected'])[1]")
    public WebElement firstBetSlipHighlited;

    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    public WebElement cookies;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main-content\"]/ms-main/div[1]/ng-scrollbar[3]/div/div/div/div/ms-widget-column/ms-widget-slot/ms-bet-column/ds-tabs-group/div[2]/ds-tab[1]/div[1]/bs-betslip/bs-betslip-linear-edit-state/div/div/div/div/bs-betslip-linear-type-list/div/bs-single-bet-linear/bs-linear-module-container/bs-digital-pick-list/bs-digital-single-bet-pick/bs-digital-single-bet-pick-info-column/div/bs-digital-pick-odds/div")
    public WebElement betSlipPickOdds;

    @FindBy(how = How.XPATH, using = "//span[text()='A-Z Sports']")
    public WebElement AZSportsMenu;


    //Methods--------------------------------
    public void openMainPage() {
        LOGGER.info("Navigate to: " + BASE_URL);
        navigateTo(BASE_URL);
    }

    public void clickEventView(){
        waitForElementVisibility(eventView);
        LOGGER.info("Click Event View");
        mouseOver(eventView);
        eventView.click();
    }

    public void clickFirstBetSlip(){
        waitForElementVisibility(firstBetSlip);
        LOGGER.info("Click First Bet Slip");
        mouseOver(firstBetSlip);
        firstBetSlip.click();
    }

    public void acceptCookies(){
        boolean enabled = cookies.isEnabled();
        if (enabled) {
            cookies.click();
            LOGGER.info("Accept cookies clicked");
        } else {
            LOGGER.info("Cookies did NOT appear");
        }
    }

    public String getFirstBetSlipAmount(){
        waitForElementVisibility(firstBetSlip);
        String firstBetSlipAmount = firstBetSlip.getText();
        LOGGER.info("FirstBetSlip is: " + firstBetSlipAmount);
        return  firstBetSlipAmount;
    }

    public String getBetSlipPickOdds(){
        waitForElementVisibility(betSlipPickOdds);
        String betSlipAmount = betSlipPickOdds.getText();
        LOGGER.info("BetSlip is: " + betSlipAmount);
        return  betSlipAmount;
    }

    public boolean  isBetslipelementHighlighted() {
        return isElementHighlighted(firstBetSlipHighlited);
    }

    public void clickAZSportMenu(){
        waitForElementVisibility(AZSportsMenu);
        LOGGER.info("Choose A-Z Sports");
        mouseOver(AZSportsMenu);
        AZSportsMenu.click();
    }

}
