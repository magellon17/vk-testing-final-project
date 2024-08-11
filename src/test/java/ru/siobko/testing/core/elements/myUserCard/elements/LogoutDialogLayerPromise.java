package ru.siobko.testing.core.elements.myUserCard.elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.loginPage.LoginPage;

public class LogoutDialogLayerPromise {

    private static final Logger log = LoggerFactory.getLogger(LogoutDialogLayerPromise.class);

    public LoginPage andWaitLoginPage() {
        log.info("Ожидаем открытия страницы входа");
        return new LoginPage();
    }
}
