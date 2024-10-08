package ru.siobko.testing.tests.userPost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.userPost.steps.CreatePostAndDisableCommentsSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckPostCommentsIconChangingAfterDisablingCommentsTest extends RequiredLoginTest {

    private final CreatePostAndDisableCommentsSteps steps = new CreatePostAndDisableCommentsSteps();

    @BeforeEach
    public void beforeTest() {
        steps.createPost();
    }

    @Test
    @Tag("userPost")
    public void testOnChangingCommentsIconAfterDisablingComments() {
        steps.disablePostComments();
        assertTrue(new HomePage().moveToCreatedPost().isCommentsOffSet(),
                "Иконка кнопки 'Комментировать' не изменилась");
    }

    @AfterEach
    public void afterTest() {
        steps.deleteCreatedPostFromHomePage();
    }
}
