package ru.siobko.testing.core.elements.publish;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.homePage.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Форма с выбором типа контента для публикации
 */
public class PublishingMenuForm extends HomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PublishingMenuForm.class);

    private static final By PUBLISH_POST_BTN = byXpath(".//*[@data-l='t,feed.posting.ui.input']");

    public PublishingMenuForm() {
        this.check();
        log.info("Открылось меню публикации медиа контента");
    }

    @Override
    public void check() throws Error {
        $(PUBLISH_POST_BTN).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста"));
    }

    public CreatingPostLayer clickOnPublishPost() {
        log.info("Кликаем на кнопку публикации поста.");
        $(PUBLISH_POST_BTN).shouldBe(
                visible.because("Не отобразилась кнопка публикации поста.")
        ).click();
        return new CreatingPostLayer();
    }
}
