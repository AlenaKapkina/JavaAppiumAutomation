package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {
    static {
//        NAME_OF_FOLDER_XPATH_TPL = "xpath:";
        ARTICLE_BY_TITLE_TPL = "xpath:";
    }

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
