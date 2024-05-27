package ru.siobko.testing.core.media.hobby;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

public class HobbyTopic {

    private static final Logger log = LoggerFactory.getLogger(HobbyTopic.class);

    private final SelenideElement topic;

    private static final By DELETE_BTN = byText("Удалить");
    private static final By CONFIRM_DELETE_BTN = byText("Удалить заметку");

    public HobbyTopic(SelenideElement topic) {
        this.topic = topic;
    }

    public HobbyTopic clickOnDelete() {
        log.info("Кликаем на кнопку 'Удалить'");
        topic.$(DELETE_BTN).shouldBe(
                visible.because("Не нашлась кнопка удаления")
        ).click();
        return this;
    }

    public void clickOnConfirmDeletion() {
        log.info("Кликаем на подтвердлающую удаление кнопку 'Удалить заметку'");
        topic.$(CONFIRM_DELETE_BTN).shouldBe(
                visible.because("Не нашлась кнопка подтверждения удаления")
        ).click();
    }
}
