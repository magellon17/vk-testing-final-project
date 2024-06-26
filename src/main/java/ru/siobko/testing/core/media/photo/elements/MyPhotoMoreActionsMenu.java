package ru.siobko.testing.core.media.photo.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.media.photo.PhotoLayer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Раскрывающееся меню дополнительных действий с собственным фото
 */
public class MyPhotoMoreActionsMenu extends PhotoLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(MyPhotoMoreActionsMenu.class);

    private static final By DELETE_PHOTO_BTN = byXpath(".//span[text()='Удалить фотографию']");

    public MyPhotoMoreActionsMenu() {
        check();
        log.info("Открылось меню дополнительных действий с фотографией");
    }

    @Override
    public void check() throws Error {
        $(DELETE_PHOTO_BTN).shouldBe(
                visible.because("Не появилась кнопка для удаления фото."));
    }

    public PhotoLayer deletePhoto() {
        log.info("Удаляем фото.");
        $(DELETE_PHOTO_BTN).shouldBe(
                visible.because("Не появилась кнопка для удаления фото.")
        ).click();
        return this;
    }
}
