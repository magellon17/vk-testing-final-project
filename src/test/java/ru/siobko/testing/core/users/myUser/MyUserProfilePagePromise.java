package ru.siobko.testing.core.users.myUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUserProfilePagePromise {

    private static final Logger log = LoggerFactory.getLogger(MyUserProfilePagePromise.class);

    public MyUserProfilePage andWaitMyUserProfilePage() {
        log.info("Ожидаем открытия страницы профиля текущего пользователя");
        return new MyUserProfilePage();
    }
}
