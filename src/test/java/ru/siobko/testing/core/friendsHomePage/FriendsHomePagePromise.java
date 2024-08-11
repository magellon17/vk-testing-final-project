package ru.siobko.testing.core.friendsHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsHomePagePromise {

    private static final Logger log = LoggerFactory.getLogger(FriendsHomePagePromise.class);

    public FriendsHomePage andWaitFriendsPage() {
        log.info("Ожидаем открытия страницы друзей текущего пользователя");
        return new FriendsHomePage();
    }
}
