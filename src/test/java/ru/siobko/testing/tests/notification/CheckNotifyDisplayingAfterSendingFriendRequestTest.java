package ru.siobko.testing.tests.notification;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.notification.steps.SendingFriendRequestAndCheckNotifySteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckNotifyDisplayingAfterSendingFriendRequestTest extends RequiredLoginTest {

    private final SendingFriendRequestAndCheckNotifySteps steps =
            new SendingFriendRequestAndCheckNotifySteps(MAIN_BOT, EXTRA_BOT);

    @BeforeEach
    public void beforeTest() {
        steps.sendFriendRequestViaGlobalSearch();
        steps.logoutIntoLoginPage();
        steps.logInReceiverBot();
    }

    @Test
    @Tag("notification")
    public void testOnNotifyDisplayingAfterPublishingPost() {
        assertTrue(new HomePage().isFriendRequestDisplayed(),
                "Уведомление о новом запросе в друзья не отобразилось");
    }

    @AfterEach
    public void afterTest() {
        steps.logoutIntoLoginPage();
        steps.logInSenderBot();
        steps.openReceiverUserPageViaGlobalSearch();
        steps.cancelFriendRequestFromUserPage();
    }
}
