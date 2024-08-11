package ru.siobko.testing.tests.notification.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.core.loginPage.LoginPage;
import ru.siobko.testing.core.userProfilePage.otherProfile.UserProfilePage;
import ru.siobko.testing.models.TestBot;

public class SendingFriendRequestAndCheckNotifySteps {

    private static final Logger log = LoggerFactory.getLogger(SendingFriendRequestAndCheckNotifySteps.class);

    private final TestBot receiverBot;
    private final TestBot senderBot;

    public SendingFriendRequestAndCheckNotifySteps(TestBot sender, TestBot receiver) {
        this.senderBot = sender;
        this.receiverBot = receiver;
    }

    public void sendFriendRequestViaGlobalSearch() {
        log.info("Отправляем запрос в друзья пользователю через поисковой результат");
        new HomePage()
                .expandGlobalSearch()
                .setText(receiverBot.login())
                .getUserCardByName(receiverBot.login())
                .clickOnSendFriendRequest()
                .collapseSearch();
    }

    public void logoutIntoLoginPage() {
        log.info("Выходим из аккаунта");
        new HomePage()
                .expandUserCardToolbar()
                .clickOnLogout()
                .confirmLogout()
                .andWaitLoginPage();
    }

    public void logInReceiverBot() {
        log.info("Логинимся в аккаунт на котором послали запрос в друзья");
        new LoginPage().login(receiverBot);
    }

    public void logInSenderBot() {
        log.info("Логинимся в аккаунт, с которого послали запрос в друзья");
        new LoginPage().login(senderBot);
    }

    public void openReceiverUserPageViaGlobalSearch() {
        log.info("Открываем страницу пользователя получателя запроса в др {}", receiverBot.login());
        new HomePage()
                .expandGlobalSearch()
                .setText(receiverBot.login())
                .getUserCardByName(receiverBot.login())
                .clickOnCard();
    }

    public void cancelFriendRequestFromUserPage() {
        log.info("Отменяем запрос в друзья со страницы пользователя, которому отправили запрос");
        new UserProfilePage()
                .expandFriendRelationsSelector()
                .clickOnRevokeFriendRequest();
    }
}
