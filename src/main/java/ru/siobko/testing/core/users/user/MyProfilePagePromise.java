package ru.siobko.testing.core.users.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProfilePagePromise {

    private static final Logger log = LoggerFactory.getLogger(MyProfilePagePromise.class);

    public UserProfilePage andWaitMyProfilePage() {
        log.info("Ожидаем открытия страницы профиля пользователя");
        return new UserProfilePage();
    }
}
