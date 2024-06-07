package ru.siobko.testing.core.users.myUser;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.users.common.CommonUserProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница профиля текущего пользователя
 */
public class MyUserProfilePage extends CommonUserProfilePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyUserProfilePage.class);

    private static final By SETTINGS_BTN = byXpath(".//*[@data-l='outlandertarget,settings,t,settings']");

    public MyUserProfilePage() {
        check();
        log.info("Загрузилась страница профиля текущего пользователя");
    }

    @Override
    public void check() throws Error {
        $(SETTINGS_BTN).shouldBe(
                visible.because("Не отобразилась кнопка настроек"));
    }
}
