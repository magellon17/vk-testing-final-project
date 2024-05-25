package ru.siobko.testing.core.home.elements.avatar;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.home.HomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RemoveAvatarLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PhotoPickerLayer.class);

    private static final By REMOVE_AVATAR_BTN = byText("Убрать");

    public RemoveAvatarLayer(){
        check();
        log.info("Открылся леер удаления аватара");
    }

    @Override
    public void check() throws Error {
        $(REMOVE_AVATAR_BTN).shouldBe(
                visible.because("Не отобразилась кнопка удаления аватара"));
    }

    public HomePage clickOnRemove() {
        log.info("Подтверждаем удаление аватара");
        $(REMOVE_AVATAR_BTN).shouldBe(
                visible.because("Не отобразилась кнопка удаления аватара")
        ).click();
        return new HomePage();
    }
}
