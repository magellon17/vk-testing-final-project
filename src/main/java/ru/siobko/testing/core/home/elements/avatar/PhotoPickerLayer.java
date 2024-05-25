package ru.siobko.testing.core.home.elements.avatar;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PhotoPickerLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PhotoPickerLayer.class);

    private static final By UPLOAD_FROM_DEVICE_INPUT = byXpath(".//input[@accept='.jpg,.jpeg,.png,.gif,.heic,.mov,video/mp4,video/x-m4v,video/*']");
    private static final By ENHANCE_PHOTO_BTN = byXpath(".//*[contains(@class,'enhance-photo-button')]");

    public PhotoPickerLayer() {
        check();
        log.info("Загрузился леер загрузки фото");
    }

    @Override
    public void check() throws Error {
        $(ENHANCE_PHOTO_BTN).shouldBe(
                visible.because("Не отобразилась кнопка украски фото рамкой"));
    }

    public ChangeUserAvatarLayer uploadAvatarPhoto(String filename) {
        log.info("Загружаем фото аватара");
        $(UPLOAD_FROM_DEVICE_INPUT)
                .uploadFile(new File(filename));
        return new ChangeUserAvatarLayer();
    }
}
