package ru.siobko.testing.tests.friends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.friends.FriendsMainPage;
import ru.siobko.testing.core.friends.search.FriendsSearchResultsPage;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.user.UserProfilePage;

public class SendFriendRequestFromFriendsSearchPageSteps {

    private static final Logger log = LoggerFactory.getLogger(SendFriendRequestFromFriendsSearchPageSteps.class);

    private final String username;

    public SendFriendRequestFromFriendsSearchPageSteps(String username) {
        this.username = username;
    }

    public void prepareTest() {
        openFriendsMainPageFromHomePage();
        enterUsernameAndOpenSearchPage();
    }

    public void tearDown() {
        openUserProfilePage();
        cancelFriendRequestFromUserPage();
    }

    public void openFriendsMainPageFromHomePage() {
        log.info("Открываем страницу ленты пользователя");
        new HomePage().openFriendsPage();
    }

    public void enterUsernameAndOpenSearchPage() {
        log.info("Вводим имя пользователя в поисковой строке и нажимаем на иконку поиска");
        new FriendsMainPage()
                .expandSearchContainer()
                .setText(username)
                .clikcOnSearchIcon();
    }

    public void sendFriendRequestToUser() {
        log.info("Отправляем запрос в друзья пользователю {}", username);
        new FriendsSearchResultsPage()
                .getUserCardByName(username)
                .clickOnSendFriendRequest();
    }

    public void openUserProfilePage() {
        log.info("Открываем страницу профиля пользователя {}", username);
        new FriendsSearchResultsPage()
                .getUserCardByName(username)
                .clickOnUserName();
    }

    public void cancelFriendRequestFromUserPage() {
        log.info("Отменяем запрос в друзья со страницы пользователя, которому отправили запрос");
        new UserProfilePage()
                .expandFriendRelationsSelector()
                .clickOnRevokeFriendRequest();
    }
}
