package ru.siobko.testing.core.hobbiesMainPage.elements.posting.postingForm;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.hobbiesMainPage.elements.politics.PostingHobbyPoliticsPromise;
import ru.siobko.testing.core.hobbiesMainPage.elements.posting.postingForm.elements.HobbyCategoriesMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PostingHobbyForm implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PostingHobbyForm.class);

    private static final By TEXT_BOX = byXpath(".//*[@role='textbox']");
    private static final By EXPAND_ADD_HOBBY_CATEGORY = byClassName("select__itohv");
    private static final By SUBMIT_BTN = byXpath(".//button[@data-l='t,button.submit']");

    public PostingHobbyForm() {
        check();
        log.info("Загрузился леер созданя увлечения");
    }

    @Override
    public void check() throws Error {
        $(EXPAND_ADD_HOBBY_CATEGORY).shouldBe(
                visible.because("Не отобразтилась кнопка 'Добавить в Увлечения'"));
    }

    public PostingHobbyForm enterText(String postText) {
        log.info("Вводим текст увлечения");
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста увлечения")
        ).setValue(postText);
        return this;
    }

    public PostingHobbyPoliticsPromise clickSubmit() {
        log.info("Публикуем увлечение");
        $(SUBMIT_BTN).shouldBe(
                visible.because("Не отобразилась кнопка публикации увлечения")
        ).click();
        return new PostingHobbyPoliticsPromise();
    }

    public HobbyCategoriesMenu expandHobbyCategoriesMenu() {
        log.info("Кликаем на 'Добавить в Увлечение'");
        $(EXPAND_ADD_HOBBY_CATEGORY).shouldBe(
                visible.because("Не отобразилась кнопка 'Добавить в Увлечение'")
        ).click();
        return new HobbyCategoriesMenu();
    }
}
