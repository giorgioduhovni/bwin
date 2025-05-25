package core;

import base.Browser;
import pages.MainPage;
import pages.TableTennis;

public class BwinWebApplication {

    private Browser browser;
    private TableTennis resultPage;
    private MainPage mainPage;

    public BwinWebApplication() {
    }

    //lazy instantiating methods

    public Browser browser() {
        if (browser == null) {
            browser=new Browser();
            return browser;
        } else {
            return browser;
        }
    }

    public TableTennis tableTennis() {
        if (resultPage == null) {
            resultPage =new TableTennis(browser.getBaseTools().driver);
            return resultPage;
        } else {
            return resultPage;
        }
    }

    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage=new MainPage(browser.getBaseTools().driver);
            return mainPage;
        } else {
            return mainPage;
        }
    }


}
