package ru.siobko.testing.core.media.photo;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.media.photo.elements.MyPhotoMoreActionsMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Фотолеер
 */
public class PhotoLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PhotoLayer.class);

    private static final By IMAGE_CONTAINER = byXpath(".//div[@data-l='t,main']");
    private static final By CLOSE_PHOTO_PAGE = byXpath(".//button[@class='panel_close__ugpyu close__ugpyu']");
    private static final By EXPAND_MORE_ACTIONS_MENU = byXpath(".//button[@class='button-clean__0wfyv action-button-container__czsac']");

    public PhotoLayer() {
        check();
        log.info("Открылася фотолеер");
    }

    @Override
    public void check() throws Error {
        $(IMAGE_CONTAINER).shouldBe(
                visible.because("Не отобразилось область под фото.")
        );
    }

    public MyPhotoMoreActionsMenu expandActionsMenu() {
        log.info("Раскрываем меню дополнитльеных действий");
        $(EXPAND_MORE_ACTIONS_MENU).shouldBe(
                visible.because("Не отобразились 3 точки меню дополнитлельных действий.")
        ).click();
        return new MyPhotoMoreActionsMenu();
    }

    /**
     * Закрывает фотолеер
     */
    public void closeLayer() {
        log.info("Закрываем фотолеер");
        $(CLOSE_PHOTO_PAGE).shouldBe(
                visible.because("Не отобразился крестик для закрытия фотолеера")
        ).click();
    }
}
