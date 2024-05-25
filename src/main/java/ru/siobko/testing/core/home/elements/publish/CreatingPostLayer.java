package ru.siobko.testing.core.home.elements.publish;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.home.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Форма с текстовым полем для написания текста поста
 */
public class CreatingPostLayer extends HomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(CreatingPostLayer.class);

    private static final By TEXT_BOX = byXpath(".//div[@data-module='postingForm/mediaText']");
    private static final By SUBMIT_BTN = byXpath(".//button[@data-l='t,button.submit']");

    public CreatingPostLayer() {
        check();
        log.info("Загрузилась форма для написания и публикации поста");
    }

    @Override
    public void check() throws Error {
        $(SUBMIT_BTN).shouldBe(
                visible.because("Не отобразилась кнопка публикации"));
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста"));
    }

    public CreatingPostLayer enterPostText(String postText) {
        log.info("Вводим текст поста");
        $(TEXT_BOX).shouldBe(
                visible.because("Не отобразилось поле ввода текста поста")
        ).setValue(postText);
        return this;
    }

    public HomePage clickSubmit() {
        log.info("Публикуем пост");
        $(SUBMIT_BTN).shouldBe(
                visible.because("Не отобразилась кнопка подтвержденря публикации поста.")
        ).click();
        return this;
    }
}
