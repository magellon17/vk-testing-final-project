package ru.siobko.testing.tests.hobbies.steps;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.hobbies.HobbiesPage;
import ru.siobko.testing.core.hobbies.elements.politics.PostingHobbyPoliticsLayer;
import ru.siobko.testing.core.hobbies.elements.posting.notify.PostedHobbyNotify;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.users.myUser.hobbies.MyHobbiesPage;
import ru.siobko.testing.models.hobby.Hobby;

public class CheckPostedHobbyNotifyDisplayingSteps {

    private static final Logger log = LoggerFactory.getLogger(CheckPostedHobbyNotifyDisplayingSteps.class);

    public void postHobby(Hobby hobby) {
        log.info("Публикуем увлечение");
        PostingHobbyPoliticsLayer postingHobbyPoliticsLayer = new HobbiesPage()
                .openPostingHobbyForm()
                .enterText(hobby.text())
                .expandHobbyCategoriesMenu()
                .selectCategory(hobby.category())
                .clickSubmit()
                .andWaitPostingHobbyPoliticsLayer();
        postingHobbyPoliticsLayer
                .closeLayer()
                .andWaitPostedHobbyNotify();
    }

    public void openHobbiesPage() {
        log.info("Открываем главную страницу увлечений");
        new HomePage()
                .goToHobbiesPage()
                .andWaitHobbiesPage();
    }

    public void openPostedHobby() {
        new PostedHobbyNotify().openPostedHobbyTopic();
    }

    public void deletePostedHobbyTopic() {
        Selenide.refresh();
        Selenide.refresh();
        new MyHobbiesPage().getLastHobbyTopic().clickOnDelete().clickOnConfirmDeletion();
    }
}
