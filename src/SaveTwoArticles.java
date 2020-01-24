import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.*;
import static io.appium.java_client.touch.offset.PointOption.point;

public class SaveTwoArticles {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/kapkina.a/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saveTwoArticlesThenDeleteOneOfThemAndCheckThatTheSecondArticleStillPresent() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'SKIP')]"),
                "Cannot find onboarding screen for skip it or cannot find the skip button",
                1
        );

        String search_line_on_main_screen = "//*[contains(@text, 'Search Wikipedia')]";

        waitForElementAndClick(
                By.xpath(search_line_on_main_screen),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String first_search_request = "Java";

        String search_line = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@text, 'Search Wikipedia')]";

        waitForElementAndSendKeys(
                By.xpath(search_line),
                first_search_request,
                "Cannot find search line",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic searching by " + first_search_request,
                15
        );

        String java_article_name = "Java (programming language)";

        waitForElementPresent(
                By.xpath("//*[@text='" + java_article_name + "']"),
                "Cannot find article title",
                15
        );

        String bookmark_button = "org.wikipedia:id/article_menu_bookmark";

        waitForElementAndClick(
                By.id(bookmark_button),
                "Cannot find button to add article to a reading list",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find onboarding button 'Got it' or there is no onboarding overlay",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/create_button"),
                "Cannot find 'Create new' button to create new reading list",
                5
        );

        String name_of_folder = "Learning programming";

        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into article folder input or there's no text input field",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot find the OK button or the button is not active or there's no text in text input field",
                5
        );

        String navigate_back = "//android.widget.ImageButton[@content-desc='Navigate up']";

        waitForElementAndClick(
                By.xpath(navigate_back),
                "Cannot close the article. Cannot find the Back button",
                5
        );

        String no_thanks = "//*[@text='NO THANKS']";

        waitForElementAndClick(
                By.xpath(no_thanks),
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' box",
                5
        );

        waitForElementAndClick(
                By.xpath(search_line_on_main_screen),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String second_search_request = "Kotlin";

        waitForElementAndSendKeys(
                By.xpath(search_line),
                second_search_request,
                "Cannot find search line",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']//*[@text='General-purpose programming language']"),
                "Cannot find 'General-purpose programming language' topic searching by " + second_search_request,
                5
        );

        String kotlin_article_name = "Kotlin (programming language)";

        waitForElementPresent(
                By.xpath("//*[@text='" + kotlin_article_name + "']"),
                "Cannot find article title",
                15
        );

        String title_before_adding_to_list = waitForElementAndGetAttribute(
                By.xpath("//android.view.View[@text='" + kotlin_article_name + "']"),
                "text",
                "Cannot find title of article",
                15
        );

        waitForElementAndClick(
                By.id(bookmark_button),
                "Cannot find button to add article to a reading list",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/item_title'][@text='" + name_of_folder + "']"),
                "Cannot find requested list by '" + name_of_folder + "' name or the list doesn't exist",
                5
        );

        waitForElementAndClick(
                By.xpath(navigate_back),
                "Cannot close the article. Cannot find the Back button",
                5
        );

        waitForElementAndClick(
                By.xpath(no_thanks),
                "Cannot find the NO THANKS button or the button is not active or there's no 'Sync reading lists' box",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot open 'My lists' page or cannot find 'My lists' button",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find needed reading list",
                5
        );

        swipeElementToLeft(
                By.xpath("//*[@text='" + java_article_name + "']"),
                "Cannot find added article"
        );

        waitForElementNotPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "The article was not deleted",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='" + kotlin_article_name + "']"),
                "There's no such article. Probably request article was deleted by mistake on the previous step",
                5
        );

        String title_after_adding_to_list = waitForElementAndGetAttribute(
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
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10
        );

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                .moveTo(point(left_x, middle_y))
                .release()
                .perform();
    }

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}
