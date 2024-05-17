package ru.siobko.testing.tests.main;

import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.login.LoginPage;
import ru.siobko.testing.tests.BaseTest;

public abstract class BaseMainTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseMainTest.class);

    @BeforeAll
    public static void login() {
        log.info("Логиним бота в аккаунт.");
        new LoginPage().login(BOT);
    }
}
