package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    private static final String
            NAME_OF_FOLDER_XPATH_TPL = "xpath://*[@text='{SUBSTRING}']",
            ARTICLE_BY_TITLE = "xpath://*[@text='{SUBSTRING}']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getNameOfFolderXpath(String substring) {
        return NAME_OF_FOLDER_XPATH_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getSavedArticleByTitleXpath(String substring) {
        return ARTICLE_BY_TITLE.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void openFolderByName(String name_of_folder) {
        this.waitForElementAndClick(
                getNameOfFolderXpath(name_of_folder),
                "Cannot find needed reading list by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        this.waitForElementPresent(
                getSavedArticleByTitleXpath(article_title),
                "Cannot find the article named" + article_title,
                5
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        this.waitForElementNotPresent(
                getSavedArticleByTitleXpath(article_title),
                "The article named" + article_title + " was not deleted",
                5
        );
    }

    public void swipeArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        this.swipeElementToLeft(
                getSavedArticleByTitleXpath(article_title),
                "Cannot find saved article by title " + article_title
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void checkThatTheArticleWasNotDeletedByMistakeByOpeningIt(String article_title) {
        this.waitForElementAndClick(
                getSavedArticleByTitleXpath(article_title),
                "There's no such article. Probably requested article was deleted by mistake on the previous step",
                5
        );
    }


}
