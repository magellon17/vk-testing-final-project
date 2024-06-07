package ru.siobko.testing.core.users.myUser.hobbies;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.media.hobby.HobbyPostWrapper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница хобби постов в профиле текущего пользователя
 */
public class MyHobbiesPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyHobbiesPage.class);

    private static final By INFO_BLOCK = byXpath(".//*[contains(@feedinfo,'В ОК обновились Увлечения!')]");
    private static final By MORE_INFO_BTN =
            byXpath(".//*[@data-l='operation,click_more_details,tag,more_details,t,click_to_link,ti,other']");
    private static final By LAST_HOBBY_TOPIC = byXpath(".//*[@class='feed_cnt']");

    public MyHobbiesPage(){
        check();
        log.info("MyHobbiesPage created");
    }

    @Override
    public void check() throws Error {
        $(INFO_BLOCK).shouldBe(
                visible.because("Не отобразился блок с информацией об увлечениях"));
        $(MORE_INFO_BTN).shouldBe(
                visible.because("Не отобразился блок с информацией об увлечениях"));
    }

    public HobbyPostWrapper getLastHobbyTopic() {
        return new HobbyPostWrapper($(LAST_HOBBY_TOPIC));
    }
}
