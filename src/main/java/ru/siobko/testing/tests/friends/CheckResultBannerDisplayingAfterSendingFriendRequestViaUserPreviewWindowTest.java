package ru.siobko.testing.tests.friends;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.user.elements.UserPreviewWindow;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.friends.steps.SendFriendRequestFromFriendSearchResultsPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckResultBannerDisplayingAfterSendingFriendRequestViaUserPreviewWindowTest extends RequiredLoginTest {

    private final SendFriendRequestFromFriendSearchResultsPageSteps steps =
            new SendFriendRequestFromFriendSearchResultsPageSteps(BOT2.login());

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    @Tag("friends")
    public void testOnResultBannerDisplayingAfterSendingFriendRequestViaUserPreviewWindow() {
        steps.sendFriendRequestToUserViaUserPreviewWindow();
        assertTrue(new UserPreviewWindow().isSentFriendRequestTitleDisplaying(),
                "Не отобразилась надпись 'Запрос отправлен' после отправки запроса в друзья");
    }

    @AfterEach
    public void afterTest() {
        steps.tearDown();
    }
}
