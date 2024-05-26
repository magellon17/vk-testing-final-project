package ru.siobko.testing.tests.friends;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.friends.search.FriendsSearchResultsPage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.friends.steps.SendFriendRequestFromFriendSearchResultsPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckResultBannerAfterSendingFriendRequestFromFriendsSearchPageTest extends RequiredLoginTest {

    private final SendFriendRequestFromFriendSearchResultsPageSteps steps =
            new SendFriendRequestFromFriendSearchResultsPageSteps(BOT2.login());

    @BeforeEach
    public void beforeTest() {
        steps.prepareTest();
    }

    @Test
    @Tag("friends")
    public void testOnCheckingResultBannerAfterSendingFriendRequest() {
        steps.sendFriendRequest();
        assertTrue(new FriendsSearchResultsPage().getUserCardByName(BOT2.login()).isSentFriendRequestBannerDisplayed(),
                "Не отобразилась надпись 'Запрос отправлен' после отправки запроса в друзья");
    }

    @AfterEach
    public void afterTest() {
        steps.tearDown();
    }
}
