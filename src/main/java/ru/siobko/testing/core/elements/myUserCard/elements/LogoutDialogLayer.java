package ru.siobko.testing.core.elements.myUserCard.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LogoutDialogLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(LogoutDialogLayer.class);

    private static final By CONFIRM_LOGOUT_BUTTON = byXpath(".//input[@data-l='t,logout']");

    public LogoutDialogLayer() {
        check();
        log.info("Открылось диалоговое окно выхода из аккаунта");
    }

    @Override
    public void check() throws Error {
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода"));
    }

    public LogoutDialogLayerPromise confirmLogout() {
        log.info("Подтвеждаем выход из аккаунта");
        $(CONFIRM_LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка подтверждения выхода")
        ).click();
        return new LogoutDialogLayerPromise();
    }
}
