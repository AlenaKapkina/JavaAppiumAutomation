package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE_TPL = "//android.view.View[@text='{SUBSTRING}']",
            FIRST_ARTICLE_IN_SEARCH_RESULTS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup",
            SECOND_ARTICLE_IN_SEARCH_RESULTS = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[2]",
            ARTICLE_NAME_TPL = "//*[@text='{SUBSTRING}']",
            BOOKMARK_BUTTON = "org.wikipedia:id/article_menu_bookmark",
            GOT_IT_BUTTON = "org.wikipedia:id/onboarding_button",
            CREATE_NEW_FAVOURITE_LIST = "org.wikipedia:id/create_button",
            NAME_OF_THE_NEW_FAVOURITE_LIST = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE = "//*[@text='NO THANKS']",
            NAME_OF_THE_OLD_FAVOURITE_LIST_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";

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
        this.waitForElementNotPresent(By.xpath(FIRST_ARTICLE_IN_SEARCH_RESULTS), "Find the first article. Search results is still on the page", 5);
    }

    public void findTheSecondArticle() {
        this.waitForElementPresent(By.xpath(SECOND_ARTICLE_IN_SEARCH_RESULTS), "Cannot find the second article or there's no articles");
    }

    public void waitForArticlePresentWithTimeout(String substring) {
        String article_name_xpath = getArticleXpath(substring);
        this.waitForElementPresent(By.xpath(article_name_xpath), "Cannot find article title " + substring, 15);
    }

    public void waitForArticlePresentWithoutTimeout(String substring) {
        String article_name_xpath = getArticleXpath(substring);
        this.waitForElementPresent(By.xpath(article_name_xpath), "Cannot find article title " + substring);
    }

    public String getArticleTitle(String substring) {
        String article_name_xpath = getArticleTitleXpath(substring);
        return this.waitForElementAndGetAttribute(By.xpath(article_name_xpath), "text", "Cannot find article title " + substring, 15);
    }

    public void addArticleToMyNewList(String name_of_folder) {
        this.waitForElementAndClick(
                By.id(BOOKMARK_BUTTON),
                "Cannot find button to add article to a reading list",
                5
        );

        this.waitForElementAndClick(
                By.id(GOT_IT_BUTTON),
                "Cannot find onboarding button 'Got it' or there is no onboarding overlay",
                5
        );

        this.waitForElementAndClick(
                By.id(CREATE_NEW_FAVOURITE_LIST),
                "Cannot find 'Create new' button to create new favourite list",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(NAME_OF_THE_NEW_FAVOURITE_LIST),
                name_of_folder,
                "Cannot put text into article folder input or there's no text input field",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot find the OK button or the button is not active or there's no text in text input field",
                5
        );
    }

    public void addArticleToMyOldList(String name_of_folder) {
        this.waitForElementAndClick(
                By.id(BOOKMARK_BUTTON),
                "Cannot find button to add article to a reading list",
                5
        );

        this.waitForElementAndClick(
                By.xpath(getOldFavouriteListXpath(name_of_folder)),
                "Cannot find requested list by '" + name_of_folder + "' name or the list doesn't exist",
                5
        );
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close the article. Cannot find the Back button",
                5
        );
    }

    public void closeTheAddedArticleAndTheNoThanksOverlay() {
        closeArticle();

        this.waitForElementAndClick(
                By.xpath(NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE),
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' overlay",
                10
        );
    }
}
