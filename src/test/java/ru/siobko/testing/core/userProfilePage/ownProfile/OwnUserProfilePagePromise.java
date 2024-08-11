package ru.siobko.testing.core.userProfilePage.ownProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnUserProfilePagePromise {

    private static final Logger log = LoggerFactory.getLogger(OwnUserProfilePagePromise.class);

    public OwnUserProfilePage andWaitMyUserProfilePage() {
        log.info("Ожидаем открытия страницы профиля текущего пользователя");
        return new OwnUserProfilePage();
    }
}
