import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class IfContainsSearchWord extends CoreTestCase {

    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testIsThereSearchWordInSearchResults() {
        /*MainPageObject.waitForElementAndClick(
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
                "Cannot find the search line to send keys in",
                5
        );

        WebElement search_request_element = MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find the search line with search results",
                15
        );

        String search_request = search_request_element.getAttribute("text");

        List<String> search_result_titles = new ArrayList<>();

        List<WebElement> titles = MainPageObject.getWebElementsByViewId(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']")
        );

        if (!titles.isEmpty()) {

            for (WebElement element :
                    titles) {
                search_result_titles.add(element.getAttribute("text"));
            }

            List<Boolean> equals = new ArrayList<>();
            int size_of_true = 0;
            for (String title :
                    search_result_titles) {
                boolean isEquals = title.contains(search_request);
                equals.add(isEquals);
                if (isEquals) size_of_true++;
            }

            assertEquals(
                    "Not all titles contain the search request word",
                    search_result_titles.size(),
                    size_of_true
            );
        } else {
            System.out.println("No results find");
        }*/
    }
}
