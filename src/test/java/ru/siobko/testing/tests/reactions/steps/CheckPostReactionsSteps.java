package ru.siobko.testing.tests.reactions.steps;

import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.home.HomePage;

public class CheckPostReactionsSteps {

    private static final Logger log = LoggerFactory.getLogger(CheckPostReactionsSteps.class);

    private static final String POST_TEXT = RandomString.make(10);

    public void createPost() {
        log.info("Публикуем пост");
        new HomePage()
                .clickPublish()
                .clickOnPublishPost()
                .enterPostText(POST_TEXT)
                .clickSubmit();
    }

    public void setKlassToCreatedPost() {
        log.info("Ставим 'Класс' созданному посту");
        new HomePage()
                .moveToCreatedPost()
                .setKlass();
    }

    public void deleteCreatedPost() {
        log.info("Удаляем созданный пост");
        new HomePage()
                .moveToCreatedPost()
                .expandActionsMenu()
                .clickOnDeletePost();
    }
}
