package ru.siobko.testing.core.users.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.users.myUser.MyUserProfilePage;

public class UserProfilePagePromise {

    private static final Logger log = LoggerFactory.getLogger(UserProfilePagePromise.class);

    public UserProfilePage andWaitUserProfilePage() {
        log.info("Ожидаем открытия страницы профиля пользователя");
        return new UserProfilePage();
    }
}
