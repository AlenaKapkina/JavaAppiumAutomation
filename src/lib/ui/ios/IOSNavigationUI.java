package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {
    static {
        MY_LISTS_XPATH = "xpath:";
    }

    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
