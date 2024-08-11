package ru.siobko.testing.tests.friendsRequests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.elements.search.GlobalSearchWrapper;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.friendsRequests.steps.SendFriendRequestFromMainSearchResultSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckResultBannerDisplayingAfterSendingFriendRequestFromSearchResultTest extends RequiredLoginTest {

    private final SendFriendRequestFromMainSearchResultSteps steps =
            new SendFriendRequestFromMainSearchResultSteps(EXTRA_BOT.login());

    @BeforeEach
    public void beforeTest() {
        steps.enterTextInGlobalSearch();
    }

    @Test
    @Tag("friends")
    public void testOnCheckingResultBannerAfterSendingFriendRequestFromSearchResult() {
        steps.sendFriendRequest();
        assertTrue(new GlobalSearchWrapper()
                        .getUserCardByName(EXTRA_BOT.login())
                        .isSentFriendRequestBannerDisplayed(),
                "Не отобразилась надпись 'Заявка отправлена' на карточке пользователя");
    }

    @AfterEach
    public void afterTest() {
        steps.openUserProfilePage();
        steps.cancelFriendRequestFromUserPage();
    }
}
