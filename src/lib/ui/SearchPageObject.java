package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SKIP_BUTTON = "//*[contains(@text, 'SKIP')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            BACK_BUTTON_ON_SEARCH_RESULT_SCREEN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void skipGreetingOnboardingScreen() {
        this.waitForElementAndClick(By.xpath(SKIP_BUTTON), "Cannot find and click skip button", 1);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
    }

    public void typeSearchRequest(String search_request) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_request, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring, 15);
    }

    public void returnOnMainPageFromSearchResults() {
        this.waitForElementAndClick(By.xpath(BACK_BUTTON_ON_SEARCH_RESULT_SCREEN), "Cannot find and click the Back button", 5);
    }

    public void clickByArticleWithSubstringToOpenIt(String substring, String search_request) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find '" + substring + "' topic searching by " + search_request + "and click on the article", 15);
    }
}
