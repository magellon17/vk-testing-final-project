package ru.siobko.testing.tests.publish.steps;

import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.homePage.HomePage;

public class PublishPostSteps {

    private static final Logger log = LoggerFactory.getLogger(PublishPostSteps.class);

    private static final String POST_TEXT = RandomString.make(10);

    public void createPost() {
        log.info("Публикуем пост");
        new HomePage()
                .clickPublish()
                .clickOnPublishPost()
                .enterPostText(POST_TEXT)
                .clickSubmit();
    }

    public void deleteCreatedPostFromHomePage() {
        log.info("Удаляем созданный пост");
        new HomePage()
                .moveToCreatedPost()
                .expandActionsMenu()
                .clickOnDeletePost();
    }
}
