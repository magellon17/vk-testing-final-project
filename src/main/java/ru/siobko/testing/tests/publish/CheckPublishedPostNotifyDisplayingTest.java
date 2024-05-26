package ru.siobko.testing.tests.publish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.publish.steps.PublishPostSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPublishedPostNotifyDisplayingTest extends RequiredLoginTest {

    private final PublishPostSteps steps = new PublishPostSteps();

    @Test
    @Tag("publish")
    public void testOnNotifyDisplayingAfterPublishingPost() {
        steps.createPost();
        assertTrue(new HomePage().isPublishedPostNotifyDisplayed(),
                "Уведомление о созданном посте не отобразилось");
    }

    @AfterEach
    public void afterTest() {
        steps.deleteCreatedPostFromHomePage();
    }
}
