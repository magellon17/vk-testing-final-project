package ru.siobko.testing.core.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePagePromise {

    private static final Logger log = LoggerFactory.getLogger(HomePagePromise.class);

    public HomePage andWaitHomePage() {
        log.info("Ожидаем открытия главной страницы");
        return new HomePage();
    }
}
