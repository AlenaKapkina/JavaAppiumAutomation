package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SKIP_BUTTON = "xpath:";
        SEARCH_INIT_ELEMENT = "xpath:";
        SEARCH_INPUT = "xpath:";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath:";
        BACK_BUTTON_ON_SEARCH_RESULT_SCREEN = "xpath:";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
