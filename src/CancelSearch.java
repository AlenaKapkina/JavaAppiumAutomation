import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class CancelSearch extends CoreTestCase {

    @Test
    public void testSearchForSomethingAndCancel() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipGreetingOnboardingScreen();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchRequest("Bugs");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        ArticlePageObject.findTheSecondArticle();
        SearchPageObject.returnOnMainPageFromSearchResults();
        ArticlePageObject.checkThatTheFirstArticleIsGone();


/*        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
                "Cannot find onboarding screen for skip it or cannot find the skip button",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]"),
                "Bugs",
                "Cannot find search line",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[2]"),
                "Cannot find the second article or there's no articles",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton"),
                "Cannot find the Back button",
                5
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup"),
                "Search results is still on the page",
                15
        );*/
    }
}
