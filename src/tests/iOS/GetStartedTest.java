package tests.iOS;

import lib.iOSTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends iOSTestCase {

    @Test
    public void testPassThroughWelcome() {
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
