package ru.siobko.testing.core.hobbiesHomePage.elements.posting.notify;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.userProfilePage.ownProfile.hobbies.MyHobbiesPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Всплывающее уведомление об опубликованном посте об увлечении
 */
public class PostedHobbyNotify implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PostedHobbyNotify.class);

    private final SelenideElement notify = $(byXpath(".//*[@class='tip-block __row']"));

    private static final By OPEN_HOBBY_POST = byText("Посмотреть");

    public PostedHobbyNotify(){
        check();
        log.info("Загрузлось уведомление об опубликованном увлечении");
    }

    @Override
    public void check() throws Error {
        notify.$(OPEN_HOBBY_POST).shouldBe(
                visible.because("Не отобразилась кнопка 'Посмотреть' для открытия опубликованного поста"));
    }

    public MyHobbiesPage openPostedHobbyTopic() {
        notify.$(OPEN_HOBBY_POST).shouldBe(
                visible.because("")
        ).click();
        return new MyHobbiesPage();
    }
}
