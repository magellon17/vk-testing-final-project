package ru.siobko.testing.core.friendsMainPage.search.searchResults;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.friendsMainPage.search.searchResults.elements.UserCardWrapper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница результатов поиска по друзьям
 */
public class FriendsSearchResultsPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(FriendsSearchResultsPage.class);

    private static final By MY_FRIENDS_SEARCH_BLOCK = By.id("hook_Block_MyFriendsFriendSearchPagingB");
    private static final By GLOBAL_SEARCH_BLOCK = By.id("hook_Block_MyFriendsGlobalSearchPagingB");
    private static final By USER_CARDS_RESULT_LIST = By.className("gs_result_list");

    public FriendsSearchResultsPage() {
        check();
        log.info("Открылась страница с результатами поиска человека среди друзей(и не только)");
    }

    @Override
    public void check() throws Error {
        $(MY_FRIENDS_SEARCH_BLOCK).shouldBe(
                visible.because("Не отобразился блок с результатами поиска пользователя среди друзей"));
        $(GLOBAL_SEARCH_BLOCK).shouldBe(
                visible.because("Не отобразился блок с результатами поиска пользователя среди всех пользователей"));
    }

    public UserCardWrapper getUserCardByName(String username) {
        SelenideElement userCard = $(USER_CARDS_RESULT_LIST)
                .$(By.xpath(".//*[contains(@data-render-log,'" + username + "')]"));
        return new UserCardWrapper(userCard);
    }
}
