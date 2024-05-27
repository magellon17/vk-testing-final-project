package ru.siobko.testing.core.users.myUser;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.users.IUserProfilePage;
import ru.siobko.testing.core.users.common.CommonUserProfilePage;
import ru.siobko.testing.core.users.myUser.elements.UserProfileMoreActionMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyUserProfilePage extends CommonUserProfilePage implements IUserProfilePage {

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

    @Override
    public UserProfileMoreActionMenu expandMoreActionsMenu() {
        $(EXPAND_MORE_ACTIONS_MENU).shouldBe(
                visible.because("Не отобразилась кнопка с тремя точками")
        ).click();
        return new UserProfileMoreActionMenu();
    }
}
