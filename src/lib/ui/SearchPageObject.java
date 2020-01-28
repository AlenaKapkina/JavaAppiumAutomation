package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
            SKIP_BUTTON = "//*[contains(@text, 'SKIP')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='{SUBSTRING}']",
            FIRST_ARTICLE_IN_SEARCH_RESULTS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup",
            SECOND_ARTICLE_IN_SEARCH_RESULTS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[2]",
            BACK_BUTTON_ON_SEARCH_RESULT_SCREEN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton",

            ARTICLE_NAME_TPL = "//*[@text='{SUBSTRING}']",
            BOOKMARK_BUTTON = "org.wikipedia:id/article_menu_bookmark",
            GOT_IT_BUTTON = "org.wikipedia:id/onboarding_button",
            CREATE_NEW_FAVOURITE_LIST = "org.wikipedia:id/create_button",
            NAME_OF_NEW_FAVOURITE_LIST = "org.wikipedia:id/text_input";



    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getArticleName(String substring) {
        return ARTICLE_NAME_TPL.replace("{SUBSTRING}", substring);
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

    public void checkThatTheFirstArticleIsGone() {
        this.waitForElementNotPresent(By.xpath(FIRST_ARTICLE_IN_SEARCH_RESULTS), "Find the first article. Search results is still on the page", 5);
    }

    public void findTheSecondArticle() {
        this.waitForElementPresent(By.xpath(SECOND_ARTICLE_IN_SEARCH_RESULTS), "Cannot find the second article or there's no articles");
    }

    public void returnOnMainPageFromSearchResults() {
        this.waitForElementAndClick(By.xpath(BACK_BUTTON_ON_SEARCH_RESULT_SCREEN), "Cannot find and click the Back button", 5);
    }

    public void clickOnTheElementInSearchResultsList(String substring, String search_request) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find '" + substring + "' topic searching by " + search_request, 15);
    }

    public void waitForArticlePresent(String substring) {
        String article_name_xpath = getArticleName(substring);
        this.waitForElementPresent(By.xpath(article_name_xpath), "Cannot find article title " + substring, 15);
    }

    public void addTheArticleToFavouriteList() {
        this.waitForElementAndClick(By.id(BOOKMARK_BUTTON), "Cannot find the bookmark button to add the article to a reading list", 5);
    }

    public void skipOnboardingOverlayWhenAddingTheArticleToFavouriteList() {
        this.waitForElementAndClick(By.id(GOT_IT_BUTTON), "Cannot find onboarding button 'Got it' or there is no onboarding overlay", 5);
    }

    public void createNewFavouriteList() {
        this.waitForElementAndClick(By.id(CREATE_NEW_FAVOURITE_LIST), "Cannot find 'Create new' button to create new favourite list", 5);
    }

    public void giveNameToNewFavouriteList(String name_of_folder) {
        this.waitForElementAndSendKeys(By.id(NAME_OF_NEW_FAVOURITE_LIST), name_of_folder, "Cannot put name '" + name_of_folder + "' into article folder input or there's no text input field", 5);
    }
}
