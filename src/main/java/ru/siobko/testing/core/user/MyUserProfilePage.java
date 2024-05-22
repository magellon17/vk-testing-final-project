package ru.siobko.testing.core.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyUserProfilePage extends UserProfilePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyUserProfilePage.class);

    private static final By SETTINGS_BUTTON = byXpath(".//*[@data-l='outlandertarget,settings,t,settings']");

    public MyUserProfilePage() {
        check();
        log.info("Открылась страница профиля текущего пользователя");
    }

    @Override
    public void check() throws Error {
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек"));
    }
}
