import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class AssertElementPresent extends CoreTestCase {

    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testFindArticleTitle() {
        MainPageObject.waitForElementAndClick(
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

        String search_request = "Java";

        String search_line = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]";

        MainPageObject.waitForElementAndSendKeys(
                By.xpath(search_line),
                search_request,
                "Cannot find search line",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + search_request,
                15
        );

        String java_article_name = "Java (programming language)";

        MainPageObject.elementPresent(
                By.xpath("//*[@text='" + java_article_name + "']"),
                "Cannot find article title"
        );
    }
}
