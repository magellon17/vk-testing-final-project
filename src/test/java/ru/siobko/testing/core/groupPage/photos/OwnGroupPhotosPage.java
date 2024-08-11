package ru.siobko.testing.core.groupPage.photos;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.groupPage.GroupPage;
import ru.siobko.testing.core.groupPage.OwnGroupPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OwnGroupPhotosPage extends GroupPhotosPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(OwnGroupPhotosPage.class);

    private static final By CREATE_ALBUM_BUTTON = byText("Создать альбом");

    public OwnGroupPhotosPage() {
        checkPage();
    }

    @Override
    public void check() {
        $(CREATE_ALBUM_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка для создания альбома группы"));
        log.info("Перешли на страницу фотографий собственной группы");
    }

    @Override
    public GroupPage openGroupMainPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnFeed();
        return new OwnGroupPage();
    }
}
