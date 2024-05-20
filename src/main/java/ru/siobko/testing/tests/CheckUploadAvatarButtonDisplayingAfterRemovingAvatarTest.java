package ru.siobko.testing.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.home.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckUploadAvatarButtonDisplayingAfterRemovingAvatarTest extends BaseRequiredLoginTest {

    private final UploadAndRemovingAvatarSteps steps = new UploadAndRemovingAvatarSteps();

    private static final String PHOTO = "src/main/java/ru/siobko/testing/tests/data/bestPhoto.jpg";

    @BeforeEach
    public void beforeTest() {
        steps.setAvatar(PHOTO);
    }

    @Test
    public void testUploadAvatarButtonDisplayingAfterRemovingAvatar() {
        Selenide.refresh();
        steps.removeAvatar();
        assertTrue(new HomePage().checkUploadAvatarButtonIsDisplayed(),
                "Кнопка загрузки аватара не пропала после установки аватара");
    }

    @AfterEach
    public void afterTest() {
        steps.removeAvatarPhotoFromProfilePage();
        steps.openHomePageFromProfilePage();
    }
}
