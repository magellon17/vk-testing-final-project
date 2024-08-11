package ru.siobko.testing.tests.friendsRequests.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.friendsHomePage.FriendsHomePage;
import ru.siobko.testing.core.friendsHomePage.search.searchResults.FriendsSearchResultsPage;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.core.userProfilePage.otherProfile.UserProfilePage;

public class SendFriendRequestFromFriendSearchResultsPageSteps {

    private static final Logger log = LoggerFactory.getLogger(SendFriendRequestFromFriendSearchResultsPageSteps.class);

    private final String username;

    public SendFriendRequestFromFriendSearchResultsPageSteps(String username) {
        this.username = username;
    }

    public void openFriendsMainPageFromHomePage() {
        log.info("Открываем страницу ленты пользователя");
        new HomePage()
                .goToFriendsPage()
                .andWaitFriendsPage();
    }

    public void enterTextInSearchFieldAndOpenSearchPage() {
        log.info("Вводим имя пользователя в поисковой строке и нажимаем на иконку поиска");
        new FriendsHomePage()
                .expandFriendsSearch()
                .setText(username)
                .clikcOnSearchIcon();
    }

    public void sendFriendRequest() {
        log.info("Отправляем запрос в друзья пользователю {}", username);
        new FriendsSearchResultsPage()
                .getUserCardByName(username)
                .clickOnSendFriendRequest();
    }

    public void sendFriendRequestToUserViaUserPreviewWindow() {
        log.info("Отправляем запрос в друзья пользователю {} через превью окошко пользователя", username);
        new FriendsSearchResultsPage()
                .getUserCardByName(username)
                .expandUserPreviewWindowViaHoveringOnUsername()
                .clickOnMakeFriendshipButton();
    }

    public void openUserProfilePage() {
        log.info("Открываем главную страницу пользователя {}", username);
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
