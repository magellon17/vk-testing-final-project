package ru.siobko.testing.core.hobbiesHomePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HobbiesHomePagePromise {

    private static final Logger log = LoggerFactory.getLogger(HobbiesHomePagePromise.class);

    public HobbiesHomePage andWaitHobbiesPage() {
        log.info("Ожидаем открытия главной страницы увлечений");
        return new HobbiesHomePage();
    }
}
