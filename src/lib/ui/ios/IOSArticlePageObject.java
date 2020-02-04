package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "xpath:";
        FIRST_ARTICLE_IN_SEARCH_RESULTS = "xpath:";
        SECOND_ARTICLE_IN_SEARCH_RESULTS = "xpath:";
        ARTICLE_NAME_TPL = "xpath:";
        BOOKMARK_BUTTON = "id:";
        GOT_IT_BUTTON = "id:";
        CREATE_NEW_FAVOURITE_LIST = "id:";
        NAME_OF_THE_NEW_FAVOURITE_LIST = "id:";
        MY_LIST_OK_BUTTON = "xpath:";
        CLOSE_ARTICLE_BUTTON = "xpath:";
        NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE = "xpath:";
        NAME_OF_THE_OLD_FAVOURITE_LIST_TPL = "xpath:";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
