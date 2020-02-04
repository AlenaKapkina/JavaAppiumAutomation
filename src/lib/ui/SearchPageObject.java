package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SKIP_BUTTON,
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            BACK_BUTTON_ON_SEARCH_RESULT_SCREEN;

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void skipGreetingOnboardingScreen() {
        this.waitForElementAndClick(SKIP_BUTTON, "Cannot find and click skip button", 1);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
    }

    public void typeSearchRequest(String search_request) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_request, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 15);
    }

    public void returnOnMainPageFromSearchResults() {
        this.waitForElementAndClick(BACK_BUTTON_ON_SEARCH_RESULT_SCREEN, "Cannot find and click the Back button", 5);
    }

    public void clickByArticleWithSubstringToOpenIt(String substring, String search_request) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find '" + substring + "' topic searching by " + search_request + "and click on the article", 15);
    }

    private WebElement waitForTitleElement(String substring) {
        return this.waitForElementPresent(getResultSearchElement(substring), "Cannot find article title on the page of search results", 15);
    }

    public String getArticleTitleFromSearchResultsIOS(String substring) {
        WebElement title_element = this.waitForTitleElement(substring);
        return title_element.getAttribute("name");
    }
}
