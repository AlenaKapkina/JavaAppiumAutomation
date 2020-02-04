package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {

    private static final String
            MY_LISTS_XPATH = "xpath://android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void openMyLists() {
        this.waitForElementAndClick(
                MY_LISTS_XPATH,
                "Cannot open 'My lists' page or cannot find 'My lists' button",
                5
        );
    }
}
