package ru.siobko.testing.tests.avatar.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.user.MyUserProfilePage;

public class UploadAndRemovingAvatarSteps {

    private static final Logger log = LoggerFactory.getLogger(UploadAndRemovingAvatarSteps.class);

    public void openHomePageFromProfilePage() {
        log.info("Открываем страницу ленты пользователя");
        new MyUserProfilePage().openHomePage();
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
        new HomePage()
                .openProfilePage()
                .openLatestPhoto()
                .expandActionsMenu()
                .deletePhoto()
                .closeLayer();
    }
}
