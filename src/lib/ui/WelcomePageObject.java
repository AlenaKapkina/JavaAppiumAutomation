package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
        STEP_LEARN_MORE_ABOUT_WIKI = "id:Learn more about Wikipedia",
        STEP_NEW_WAYS_TO_EXPLORE = "id:New ways to explore",
        STEP_ADD_OR_EDIT_PREFERRED_LANGUAGES = "id:Add or edit preferred languages",
        STEP_LEARN_MORE_ABOUT_DATA = "id:Learn more about data collected",
        NEXT = "id:Next",
        GET_STARTED = "id:Get started",
        SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreWikiLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_WIKI, "Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void waitForNewWaysText() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE, "Cannot find 'New ways to explore' link", 10);
    }

    public void waitForAddOrEditText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANGUAGES, "Cannot find 'Add or edit preferred languages' link", 10);
    }

    public void waitForLearnMoreDataText() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA, "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(NEXT, "Cannot find and click 'Next' button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED, "Cannot find and click 'Get started' button", 10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Cannot find and click skip button", 5);
    }
}
