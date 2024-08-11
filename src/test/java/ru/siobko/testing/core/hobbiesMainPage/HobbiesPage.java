package ru.siobko.testing.core.hobbiesMainPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.hobbiesMainPage.elements.posting.postingForm.PostingHobbyForm;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница увлечений текущего пользователя
 */
public class HobbiesPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(HobbiesPage.class);

    private static final By HOBBY_POSTING_INPUT = byXpath(".//*[@data-l='t,feed.posting.ui.input']");
    private static final By POSTED_HOBBY_NOTIFY = byText("Ваша публикация отправлена на модерацию");

    public HobbiesPage(){
        check();
        log.info("Загрузилась главная страница увлечений");
    }

    @Override
    public void check() throws Error {
        $(HOBBY_POSTING_INPUT).shouldBe(
                visible.because("Не отобразился блок создания увлечения"));
    }

    public PostingHobbyForm openPostingHobbyForm() {
        log.info("Кликаем на кнопку 'Опубликовать'.");
        $(HOBBY_POSTING_INPUT).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return new PostingHobbyForm();
    }

    public boolean isPublishedPostNotifyDisplayed() {
        return $(POSTED_HOBBY_NOTIFY).shouldBe(visible).isDisplayed();
    }

}
