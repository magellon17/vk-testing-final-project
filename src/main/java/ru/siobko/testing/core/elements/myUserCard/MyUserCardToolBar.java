package ru.siobko.testing.core.elements.myUserCard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.myUserCard.elements.LogoutDialogLayer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Раскрывающееся меню настроек пользователя в правом верхнем углу
 */
public class MyUserCardToolBar implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyUserCardToolBar.class);

    private static final SelenideElement toolbar = $(byId("user-dropdown-menu"));

    private static final By LOGOUT_BUTTON = byXpath(".//a[@data-l='t,logout']");

    public MyUserCardToolBar() {
        check();
        log.info("Загрузилось меню карточки текущего пользователя");
    }

    @Override
    public void check() throws Error {
        toolbar.$(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта"));
    }

    public LogoutDialogLayer clickOnLogout() {
        log.info("Кликаем на кнопку 'Выйти'");
        toolbar.$(LOGOUT_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка выхода из аккаунта")
        ).click();
        return new LogoutDialogLayer();
    }
}
