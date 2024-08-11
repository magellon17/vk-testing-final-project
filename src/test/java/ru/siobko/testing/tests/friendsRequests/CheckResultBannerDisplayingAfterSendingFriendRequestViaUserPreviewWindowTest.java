package ru.siobko.testing.tests.friendsRequests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.userProfilePage.common.elements.UserPreviewWindow;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.friendsRequests.steps.SendFriendRequestFromFriendSearchResultsPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckResultBannerDisplayingAfterSendingFriendRequestViaUserPreviewWindowTest extends RequiredLoginTest {

    private final SendFriendRequestFromFriendSearchResultsPageSteps steps =
            new SendFriendRequestFromFriendSearchResultsPageSteps(EXTRA_BOT.login());

    @BeforeEach
    public void beforeTest() {
        steps.openFriendsMainPageFromHomePage();
        steps.enterTextInSearchFieldAndOpenSearchPage();
    }

    @Test
    @Tag("friends")
    public void testOnResultBannerDisplayingAfterSendingFriendRequestViaUserPreviewWindow() {
        steps.sendFriendRequestToUserViaUserPreviewWindow();
        assertTrue(new UserPreviewWindow().isSentFriendRequestTitleDisplaying(),
                "Не отобразилась надпись 'Запрос отправлен' в превью окошке пользователя");
    }

    @AfterEach
    public void afterTest() {
        steps.openUserProfilePage();
        steps.cancelFriendRequestFromUserPage();
    }
}
