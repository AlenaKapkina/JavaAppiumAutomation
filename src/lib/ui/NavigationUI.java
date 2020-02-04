package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LISTS_LINK;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void openMyLists() {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot open 'My lists' page or cannot find 'My lists' button",
                5
        );
    }
}
