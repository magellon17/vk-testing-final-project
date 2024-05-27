package ru.siobko.testing.tests.avatar;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.avatar.steps.UploadAndRemovingAvatarSteps;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckUploadAvatarButtonHidingAfterUploadingAvatarTest extends RequiredLoginTest {

    private final UploadAndRemovingAvatarSteps steps = new UploadAndRemovingAvatarSteps();

    private static final String PHOTO = "src/main/java/ru/siobko/testing/tests/data/avatar.PNG";

    @Test
    @Tag("avatar")
    public void testUploadAvatarButtonHidingAfterUploadingAvatar() {
        steps.setAvatar(PHOTO);
        Selenide.refresh();
        assertFalse(new HomePage().isUploadAvatarButtonDisplayed(),
                "Кнопка загрузки аватара не пропала после установки аватара");
    }

    @AfterEach
    public void afterTest() {
        steps.removeAvatar();
        steps.openProfilePageFromHomePage();
        steps.removeAvatarPhotoFromProfilePage();
    }
}
