package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SKIP_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Skip']";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        BACK_BUTTON_ON_SEARCH_RESULT_SCREEN = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
