package ru.siobko.testing.tests.avatar;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.tests.BaseRequiredLoginTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckUploadAvatarButtonHidingAfterUploadingAvatarTest extends BaseRequiredLoginTest {

    private final UploadAndRemovingAvatarSteps steps = new UploadAndRemovingAvatarSteps();

    private static final String PHOTO = "src/main/java/ru/siobko/testing/tests/data/bestPhoto.jpg";

    @Test
    public void testUploadAvatarButtonHidingAfterUploadingAvatar() {
        steps.setAvatar(PHOTO);
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