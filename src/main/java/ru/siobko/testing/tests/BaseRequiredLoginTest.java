package ru.siobko.testing.tests;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.core.login.LoginPage;

public abstract class BaseRequiredLoginTest extends BaseTest {
    @BeforeAll
    public static void login() {
        new LoginPage().login(BOT);
    }
}
