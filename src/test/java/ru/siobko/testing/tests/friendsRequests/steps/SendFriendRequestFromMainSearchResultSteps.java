package ru.siobko.testing.tests.friendsRequests.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.elements.search.GlobalSearchWrapper;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.core.profilePage.otherProfile.UserProfilePage;

public class SendFriendRequestFromMainSearchResultSteps {

    private static final Logger log = LoggerFactory.getLogger(SendFriendRequestFromMainSearchResultSteps.class);

    private final String username;

    public SendFriendRequestFromMainSearchResultSteps(String username) {
        this.username = username;
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
                .andWaitUserProfilePage();
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
