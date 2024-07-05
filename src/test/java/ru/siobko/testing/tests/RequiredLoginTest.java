package ru.siobko.testing.tests;

import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.core.login.LoginPage;

public abstract class RequiredLoginTest extends UITest {
    @BeforeAll
    public static void login() {
        new LoginPage().login(MAIN_BOT);
    }
}
