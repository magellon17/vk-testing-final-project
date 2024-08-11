package ru.siobko.testing.tests.avatar.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.core.userProfilePage.ownProfile.OwnUserProfilePage;

public class UploadAndRemovingAvatarSteps {

    private static final Logger log = LoggerFactory.getLogger(UploadAndRemovingAvatarSteps.class);

    public void openHomePageFromProfilePage() {
        log.info("Открываем главную страницу текущего пользователя");
        new OwnUserProfilePage()
                .openHomePage()
                .andWaitHomePage();
    }

    public void openProfilePageFromHomePage() {
        log.info("Открываем страницу профиля текущего пользователя");
        new HomePage()
                .goToProfilePage()
                .andWaitMyUserProfilePage();
    }

    public void setAvatar(String filename) {
        log.info("Ставим аватар");
        new HomePage()
                .clikcOnAddAvatar()
                .uploadAvatarPhoto(filename)
                .confirmAvatarUploading();
    }

    public void removeAvatar() {
        log.info("Убираем аватар");
        new HomePage()
                .expandAvatarShortcutMenu()
                .clickOnRemoveUserAvatar()
                .clickOnRemove();
    }

    public void removeAvatarPhotoFromProfilePage() {
        log.info("Удаляем фотографию аватара с профиля");
        new OwnUserProfilePage()
                .openLatestPhoto()
                .expandActionsMenu()
                .deletePhoto()
                .closeLayer();
    }
}
