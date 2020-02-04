package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
            TITLE_TPL = "xpath://android.view.View[@text='{SUBSTRING}']";
            FIRST_ARTICLE_IN_SEARCH_RESULTS = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup";
            SECOND_ARTICLE_IN_SEARCH_RESULTS = "xpath:/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[2]";
            ARTICLE_NAME_TPL = "xpath://*[@text='{SUBSTRING}']";
            BOOKMARK_BUTTON = "id:org.wikipedia:id/article_menu_bookmark";
            GOT_IT_BUTTON = "id:org.wikipedia:id/onboarding_button";
            CREATE_NEW_FAVOURITE_LIST = "id:org.wikipedia:id/create_button";
            NAME_OF_THE_NEW_FAVOURITE_LIST = "id:org.wikipedia:id/text_input";
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
            NO_THANKS_OVERLAY_AFTER_CLOSING_THE_ADDED_ARTICLE = "xpath://*[@text='NO THANKS']";
            NAME_OF_THE_OLD_FAVOURITE_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }





}
