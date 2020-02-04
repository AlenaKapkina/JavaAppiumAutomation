package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE_TPL,
            TITLE,
            FIRST_ARTICLE_IN_SEARCH_RESULTS,
            SECOND_ARTICLE_IN_SEARCH_RESULTS,
            ARTICLE_NAME_TPL,
            BOOKMARK_BUTTON,
            GOT_IT_BUTTON,
            CREATE_NEW_FAVOURITE_LIST,
            NAME_OF_THE_NEW_FAVOURITE_LIST,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE,
            NAME_OF_THE_OLD_FAVOURITE_LIST_TPL;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getArticleXpath(String substring) {
        return ARTICLE_NAME_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getArticleTitleXpath(String substring) {
        return TITLE_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getOldFavouriteListXpath(String substring) {
        return NAME_OF_THE_OLD_FAVOURITE_LIST_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void checkThatTheFirstArticleIsGone() {
        this.waitForElementNotPresent(FIRST_ARTICLE_IN_SEARCH_RESULTS, "Find the first article. Search results is still on the page", 5);
    }

    public void findTheSecondArticle() {
        this.waitForElementPresent(SECOND_ARTICLE_IN_SEARCH_RESULTS, "Cannot find the second article or there's no articles");
    }

    public void waitForArticlePresentWithTimeout(String substring) {
        String article_name_xpath = getArticleXpath(substring);
        this.waitForElementPresent(article_name_xpath, "Cannot find article title " + substring, 15);
    }

    public void waitForArticlePresentWithoutTimeout(String substring) {
        String article_name_xpath = getArticleXpath(substring);
        this.waitForElementPresent(article_name_xpath, "Cannot find article title " + substring);
    }

    public String getArticleTitleAndroid(String substring) {
        String article_name_xpath = getArticleTitleXpath(substring);
        return this.waitForElementAndGetAttribute(article_name_xpath, "text", "Cannot find article title " + substring, 15);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on the page", 15);
    }

    public String getArticleTitleIOS() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("name");
    }

    public void addArticleToMyNewList(String name_of_folder) {
        this.waitForElementAndClick(
                BOOKMARK_BUTTON,
                "Cannot find button to add article to a reading list",
                5
        );

        this.waitForElementAndClick(
                GOT_IT_BUTTON,
                "Cannot find onboarding button 'Got it' or there is no onboarding overlay",
                5
        );

        this.waitForElementAndClick(
                CREATE_NEW_FAVOURITE_LIST,
                "Cannot find 'Create new' button to create new favourite list",
                5
        );

        this.waitForElementAndSendKeys(
                NAME_OF_THE_NEW_FAVOURITE_LIST,
                name_of_folder,
                "Cannot put text into article folder input or there's no text input field",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find the OK button or the button is not active or there's no text in text input field",
                5
        );
    }

    public void addArticleToMyOldList(String name_of_folder) {
        this.waitForElementAndClick(
                BOOKMARK_BUTTON,
                "Cannot find button to add article to a reading list",
                5
        );

        this.waitForElementAndClick(
                getOldFavouriteListXpath(name_of_folder),
                "Cannot find requested list by '" + name_of_folder + "' name or the list doesn't exist",
                5
        );
    }

    public void addArticleToMySaved() {
        this.waitForElementAndClick(BOOKMARK_BUTTON, "Cannot find and click bookmark button to add article to reading list", 5);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close the article. Cannot find the Back button",
                5
        );
    }

    public void closeTheAddedArticleAndTheNoThanksOverlay() {
        closeArticle();

        this.waitForElementAndClick(
                NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE,
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' overlay",
                10
        );
    }
}
