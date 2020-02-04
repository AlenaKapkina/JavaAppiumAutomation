package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

        if (Platform.getInstance().isAndroid()) {
            return;
        }

        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreWikiLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreDataText();
        WelcomePage.clickGetStartedButton();
    }
}
