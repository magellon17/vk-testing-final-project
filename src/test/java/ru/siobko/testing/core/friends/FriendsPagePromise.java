package ru.siobko.testing.core.friends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsPagePromise {

    private static final Logger log = LoggerFactory.getLogger(FriendsPagePromise.class);

    public FriendsMainPage andWaitFriendsPage() {
        log.info("Ожидаем открытия страницы друзей текущего пользователя");
        return new FriendsMainPage();
    }
}
