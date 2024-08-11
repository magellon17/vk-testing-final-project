package ru.siobko.testing.core.hobbiesMainPage.elements.posting.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostedHobbyNotifyPromise {

    private static final Logger log = LoggerFactory.getLogger(PostedHobbyNotifyPromise.class);

    public PostedHobbyNotify andWaitPostedHobbyNotify() {
        log.info("Ожидаем появления уведомления об опубликованном увлечении");
        return new PostedHobbyNotify();
    }
}
