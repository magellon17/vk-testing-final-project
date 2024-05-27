package ru.siobko.testing.tests.friendsRequests.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.elements.search.GlobalSearchWrapper;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.users.user.UserProfilePage;

public class SendFriendRequestFromMainSearchResultSteps {

    private static final Logger log = LoggerFactory.getLogger(SendFriendRequestFromMainSearchResultSteps.class);

    private final String username;

    public SendFriendRequestFromMainSearchResultSteps(String username) {
        this.username = username;
    }

    public void prepareTest() {
        enterTextInGlobalSearch();
    }

    public void tearDown() {
        openUserProfilePage();
        cancelFriendRequestFromUserPage();
    }

    public void enterTextInGlobalSearch() {
        log.info("Вводим имя пользователя в поисковой строке");
        new HomePage()
                .expandGlobalSearch()
                .setText(username);
    }

    public void openUserProfilePage() {
        log.info("Открываем главную страницу пользователя {}", username);
        new GlobalSearchWrapper()
                .getUserCardByName(username)
                .clickOnCard()
                .andWaitMyProfilePage();
    }

    public void sendFriendRequest() {
        log.info("Отправляем запрос в друзья пользователю {}", username);
        new GlobalSearchWrapper()
                .getUserCardByName(username)
                .clickOnSendFriendRequest();
    }

    public void cancelFriendRequestFromUserPage() {
        log.info("Отменяем запрос в друзья со страницы пользователя, которому отправили запрос");
        new UserProfilePage()
                .expandFriendRelationsSelector()
                .clickOnRevokeFriendRequest();
    }
}
