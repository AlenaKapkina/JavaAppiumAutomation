import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class SaveTwoArticles extends CoreTestCase {

    @Test
    public void testSaveTwoArticlesThenDeleteOneOfThemAndCheckThatTheSecondArticleStillPresent() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipGreetingOnboardingScreen();
        SearchPageObject.initSearchInput();

        String first_search_request = "Java";

        SearchPageObject.typeSearchRequest(first_search_request);

        String topic_of_first_requested_article = "Object-oriented programming language";

        SearchPageObject.clickByArticleWithSubstringToOpenIt(topic_of_first_requested_article, first_search_request);

        String java_article_name = "Java (programming language)";

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForArticlePresentWithTimeout(java_article_name);

        String name_of_folder = "Learning programming";

        ArticlePageObject.addArticleToMyNewList(name_of_folder);
        ArticlePageObject.closeTheAddedArticleAndTheNoThanksOverlay();
        SearchPageObject.initSearchInput();

        String second_search_request = "Kotlin";

        SearchPageObject.typeSearchRequest(second_search_request);

        String topic_of_second_requested_article = "General-purpose programming language";

        SearchPageObject.clickByArticleWithSubstringToOpenIt(topic_of_second_requested_article, second_search_request);

        String kotlin_article_name = "Kotlin (programming language)";

        ArticlePageObject.waitForArticlePresentWithTimeout(kotlin_article_name);

        String title_before_adding_to_list = ArticlePageObject.getArticleTitle(kotlin_article_name);

        ArticlePageObject.addArticleToMyOldList(name_of_folder);
        ArticlePageObject.closeTheAddedArticleAndTheNoThanksOverlay();

        NavigationUI NavigationUI = new NavigationUI(driver);

        NavigationUI.openMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);

        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeArticleToDelete(java_article_name);
        MyListsPageObject.checkThatTheArticleWasNotDeletedByMistakeByOpeningIt(kotlin_article_name);

        String title_after_adding_to_list = ArticlePageObject.getArticleTitle(kotlin_article_name);

        assertEquals(
                "The titles are not the same",
                title_before_adding_to_list,
                title_after_adding_to_list
        );


/*        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
                "Cannot find onboarding screen for skip it or cannot find the skip button",
                1
        );

        String search_line_on_main_screen = "//*[contains(@text, 'Search Wikipedia')]";

        MainPageObject.waitForElementAndClick(
                By.xpath(search_line_on_main_screen),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String first_search_request = "Java";

        String search_line = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath(search_line),
                first_search_request,
                "Cannot find search line",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + first_search_request,
                15
        );

        String java_article_name = "Java (programming language)";

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + java_article_name + "']"),
                "Cannot find article title",
                15
        );

        String bookmark_button = "org.wikipedia:id/article_menu_bookmark";

        MainPageObject.waitForElementAndClick(
                By.id(bookmark_button),
                "Cannot find button to add article to a reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find onboarding button 'Got it' or there is no onboarding overlay",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/create_button"),
                "Cannot find 'Create new' button to create new reading list",
                5
        );

        String name_of_folder = "Learning programming";

        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into article folder input or there's no text input field",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find the OK button or the button is not active or there's no text in text input field",
                5
        );

        String navigate_back = "//android.widget.ImageButton[@content-desc='Navigate up']";

        MainPageObject.waitForElementAndClick(
                By.xpath(navigate_back),
                "Cannot close the article. Cannot find the Back button",
                5
        );

        String no_thanks = "//*[@text='NO THANKS']";

        MainPageObject.waitForElementAndClick(
                By.xpath(no_thanks),
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' box",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath(search_line_on_main_screen),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String second_search_request = "Kotlin";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath(search_line),
                second_search_request,
                "Cannot find search line",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='General-purpose programming language']"),
                "Cannot find 'General-purpose programming language' topic searching by " + second_search_request,
                5
        );

        String kotlin_article_name = "Kotlin (programming language)";

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='" + kotlin_article_name + "']"),
                "Cannot find article title",
                15
        );

        String title_before_adding_to_list = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//android.view.View[@text='" + kotlin_article_name + "']"),
                waitForElementAndGetAttribute,
                "Cannot find title of article",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.id(bookmark_button),
                "Cannot find button to add article to a reading list",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='" + name_of_folder + "']"),
                "Cannot find requested list by '" + name_of_folder + "' name or the list doesn't exist",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath(navigate_back),
                "Cannot close the article. Cannot find the Back button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath(no_thanks),
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' box",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot open 'My lists' page or cannot find 'My lists' button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find needed reading list",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='" + java_article_name + "']"),
                "Cannot find added article"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "The article was not deleted",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='" + kotlin_article_name + "']"),
                "There's no such article. Probably requested article was deleted by mistake on the previous step",
                5
        );

        String title_after_adding_to_list = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//android.view.View[@text='" + kotlin_article_name + "']"),
                "text",
                "Cannot find title of article",
                15
        );

        assertEquals(
                "The titles are not the same",
                title_before_adding_to_list,
                title_after_adding_to_list
        );
        */
    }
}
