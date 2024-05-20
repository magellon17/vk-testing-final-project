package ru.siobko.testing.core.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.SideNavigationBlock;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.media.photo.PhotoLayer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MyUserProfilePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyUserProfilePage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By SETTINGS_BUTTON = byXpath(".//*[@data-l='outlandertarget,settings,t,settings']");
    private static final By OPEN_LATEST_USER_PHOTO = byXpath(".//*[@data-l='targetPosition,0']");

    public MyUserProfilePage() {
        isLoaded();
    }

    @Override
    public void isLoaded() throws Error {
        $(SETTINGS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка настроек"));
        log.info("Перешли на страницу профиля текущего пользователя");
    }

    public PhotoLayer openLatestPhoto() {
        log.info("Открываем последнее фото профиля");
        $(OPEN_LATEST_USER_PHOTO).shouldBe(
                visible.because("Не отобразилась кнопка настроек")
        ).click();
        return new PhotoLayer();
    }

    public HomePage openHomePage() {
        log.info("Переходим на страницу ленты");
        sideNavigationBlock.clickOnHome();
        return new HomePage();
    }
}
