package ru.siobko.testing.core.home.elements.avatar;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.home.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ChangeUserAvatarLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(ChangeUserAvatarLayer.class);

    private static final By CONFIRM = byXpath(".//span[text()='Установить']");
    private static final By TITLE = byText("Выберите область фотографии");

    public ChangeUserAvatarLayer() {
        check();
        log.info("Загрузился леер загрзуки аватара");
    }

    @Override
    public void check() throws Error {
        $(TITLE).shouldBe(
                visible.because("Не загрузился заголовок леера"));
    }

    public HomePage confirmAvatarUploading() {
        log.info("Загружаем фото аватара");
        $(CONFIRM).shouldBe(
                visible.because("Не отобразилась кнопка загрузки фото")
        ).click();
        return new HomePage();
    }
}
