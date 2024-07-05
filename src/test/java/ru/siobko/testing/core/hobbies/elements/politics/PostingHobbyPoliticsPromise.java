package ru.siobko.testing.core.hobbies.elements.politics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostingHobbyPoliticsPromise {

    private static final Logger log = LoggerFactory.getLogger(PostingHobbyPoliticsPromise.class);

    public PostingHobbyPoliticsLayer andWaitPostingHobbyPoliticsLayer() {
        log.info("Ожидаем открытия леера информации по модерации поста об увлеччениях");
        return new PostingHobbyPoliticsLayer();
    }
}
