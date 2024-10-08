package ru.siobko.testing.core.homePage.elements.avatar;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AvatarShortcutMenu implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PhotoPickerLayer.class);

    private static final SelenideElement menu = $(byXpath(".//*[@data-l='t,shortcutMenu']"));

    private static final By DELETE_AVATAR_BTN = byText("Убрать фото профиля");

    public AvatarShortcutMenu() {
        check();
        log.info("Открылось контекстное меню аватара");
    }

    @Override
    public void check() throws Error {
        menu.$(DELETE_AVATAR_BTN).shouldBe(
                visible.because("Не отобразилась кнопка удаления аватара"));
    }

    public RemoveAvatarLayer clickOnRemoveUserAvatar() {
        log.info("Кликаем на 'Убрать фото профиля' в контекстном меню аватара");
        menu.$(DELETE_AVATAR_BTN).shouldBe(
                visible.because("Не отобразилась кнопка удаления аватара")
        ).click();
        return new RemoveAvatarLayer();
    }
}
