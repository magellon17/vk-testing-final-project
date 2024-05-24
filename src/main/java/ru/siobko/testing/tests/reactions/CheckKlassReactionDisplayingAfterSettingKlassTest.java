package ru.siobko.testing.tests.reactions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.media.post.PostWrapper;
import ru.siobko.testing.tests.RequiredLoginTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckKlassReactionDisplayingAfterSettingKlassTest extends RequiredLoginTest {

    private final CheckPostReactionsSteps steps = new CheckPostReactionsSteps();

    @BeforeEach
    public void beforeTest() {
        steps.createPost();
    }

    @Test
    public void testOnKlassReactionDisplayingAfterSettingKlassTest() {
        steps.setKlassToCreatedPost();
        PostWrapper post = new HomePage()
                .moveToCreatedPost();
        assertTrue(post.isReactionSet(),
                "Реакция на пост не отобразилась");
    }

    @AfterEach
    public void afterTest() {
        steps.deleteCreatedPost();
    }
}
