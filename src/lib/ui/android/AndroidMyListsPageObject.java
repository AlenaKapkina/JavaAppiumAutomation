package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static {
        NAME_OF_FOLDER_XPATH_TPL = "xpath://*[@text='{SUBSTRING}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{SUBSTRING}']";
    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
