package ru.siobko.testing.core.hobbies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HobbiesPagePromise {

    private static final Logger log = LoggerFactory.getLogger(HobbiesPagePromise.class);

    public HobbiesPage andWaitHobbiesPage() {
        log.info("Ожидаем открытия главной страницы увлечений");
        return new HobbiesPage();
    }
}
