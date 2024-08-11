package ru.siobko.testing.tests.avatar;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.avatar.steps.UploadAndRemovingAvatarSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckUploadAvatarButtonDisplayingAfterRemovingAvatarTest extends RequiredLoginTest {

    private final UploadAndRemovingAvatarSteps steps = new UploadAndRemovingAvatarSteps();

    private static final String PHOTO = "src/test/java/ru/siobko/testing/resources/test/avatar.PNG";

    @BeforeEach
    public void beforeTest() {
        steps.setAvatar(PHOTO);
    }

    @Test
    @Tag("avatar")
    public void testUploadAvatarButtonDisplayingAfterRemovingAvatar() {
        Selenide.refresh();
        steps.removeAvatar();
        assertTrue(new HomePage().isUploadAvatarButtonDisplayed(),
                "Кнопка загрузки аватара не пропала после установки аватара");
    }

    @AfterEach
    public void afterTest() {
        steps.openProfilePageFromHomePage();
        steps.removeAvatarPhotoFromProfilePage();
    }
}
