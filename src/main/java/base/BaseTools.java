package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class BaseTools {

    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTools.class);
    protected final String BASE_URL = GlobalProperties.getInstance().getBaseUrl();

    public WebDriver driver;

    public BaseTools() {

    }

    public BaseTools(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    protected WebElement waitForElementVisibility(WebElement elementToBeVisible) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        WebElement foundElementAfterWait = wait.until(ExpectedConditions.visibilityOf(elementToBeVisible));

        // You can set it back to 10 seconds if needed
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return foundElementAfterWait;
    }

    public void typeText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public void selectText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.sendKeys(text);
    }

    protected void mouseOver(WebElement element) {
        LOGGER.info("Scrolling...");
        Actions action = new Actions(driver);
        //This will perform mouseover function
        action.moveToElement(element);
    }

    protected boolean  isElementHighlighted(WebElement element) {
        String backgroundColor = element.getCssValue("background-color");
        boolean isHighlighted = backgroundColor != null && !backgroundColor.equals("rgba(0, 0, 0, 0)");

        if (isHighlighted) {
            LOGGER.info("Element is successfully highlighted!");
        } else {
            LOGGER.warn("Element is NOT highlighted");
        }

        return isHighlighted;
    }

    protected void assertSportPageLoaded(String expectedSport) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.toLowerCase().contains(expectedSport.toLowerCase())) {
            LOGGER.info("URL check passed: " + currentUrl);
        } else {
            LOGGER.warn("URL check FAILED! URL does not contain the expected sport. Current URL: " + currentUrl);
            throw new AssertionError("URL does not contain the expected sport. Current URL: " + currentUrl);
        }
    }

    public void checkUpdateOdds(WebElement element) throws InterruptedException {
        waitForElementVisibility(element);
        String oldOdds = element.getText();
        LOGGER.info("Initial Odd:" + oldOdds);

        for (int i = 0; i < 20; i++) {
            Thread.sleep(5000);

            String newOdds = element.getText();
            if (!newOdds.equals(oldOdds)) {
                LOGGER.info("Odds updated: " + newOdds);
                break;
            } else {
                LOGGER.info("No update yet...");
            }
        }
    }

    public void checkUpdateColorsIndicator(WebElement element) throws InterruptedException {

        String initialClassAttr = element.getAttribute("class");
        boolean isGreen = initialClassAttr.contains("option-indicator increased");
        boolean isRed = initialClassAttr.contains("option-indicator decreased");

        if (isGreen) {
            LOGGER.info("Initially green indicator (odds went up)");
        } else if (isRed) {
            LOGGER.info("Initially red indicator (odds went down)");
        } else {
            LOGGER.info("No indicator detected!!!");
        }

        //boolean updated = false;
        for (int i = 0; i < 50; i++) {
            Thread.sleep(2000);

            String newIndicator = element.getAttribute("class");

            if (!initialClassAttr.equals(newIndicator)) {
                LOGGER.info("Indicator was updated");
                break;
            } else {
                LOGGER.info("No indicator update yet...");
            }
        }
    }


}