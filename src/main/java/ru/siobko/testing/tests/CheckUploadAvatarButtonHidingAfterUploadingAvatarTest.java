package ru.siobko.testing.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.siobko.testing.core.home.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class CheckUploadAvatarButtonHidingAfterUploadingAvatarTest extends BaseRequiredLoginTest {

    private final UploadAvatarSteps steps = new UploadAvatarSteps();

    private static final String JPG_PHOTO = "src/main/java/ru/siobko/testing/tests/data/bestPhoto.jpg";
    private static final String PNG_PHOTO = "src/main/java/ru/siobko/testing/tests/data/IMG_1932.PNG";

    @ParameterizedTest(name = "Фото: {0}")
    @ValueSource(strings = {JPG_PHOTO, PNG_PHOTO})
    public void testPublishPhoto(String filename) {
        steps.setAvatar(filename);
        Selenide.refresh();
        assertFalse(new HomePage().checkUploadAvatarButtonIsDisplayed(),
                "Кнопка загрузки аватара не пропала после установки аватара");
    }

    @AfterEach
    public void afterTest() {
        steps.removeAvatar();
        steps.removeAvatarPhotoFromProfilePage();
        steps.openHomePageFromProfilePage();
    }
}
