package ru.siobko.testing.core.login;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.models.TestBot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private static final By LOGIN_FIELD = byName("st.email");
    private static final By PASSWORD_FIELD = byName("st.password");
    private static final By SUBMIT_BTN = byValue("Войти в Одноклассники");

    public LoginPage() {
        check();
        log.info("Загрузилась страница входа");
    }

    @Override
    public void check() throws Error {
        $(LOGIN_FIELD).shouldBe(
                exist.because("Не отобразилось поле логина")
        );
        $(PASSWORD_FIELD).shouldBe(
                exist.because("Не отобразилось поле пароля")
        );
        $(SUBMIT_BTN).shouldBe(
                exist.because("Не отобразилась кнопка входа")
        );
    }

    public LoginPage enterLogin(String login) {
        log.info("Вводим логин");
        $(LOGIN_FIELD).shouldBe(
                visible.because("Не отобразилось поле логина")
        ).setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Вводим пароль");
        $(PASSWORD_FIELD).shouldBe(
                visible.because("Не отобразилось поле пароля")
        ).setValue(password);
        return this;
    }

    public HomePage clickSubmit() {
        log.info("Кликаем на кнопку входа");
        $(SUBMIT_BTN).shouldBe(
                visible.because("Не отобразилась кнопка входа")
        ).click();
        return new HomePage();
    }

    public HomePage login(TestBot bot) {
        log.info("Выполняем вход в аккаунт");
        return enterLogin(bot.login())
                .enterPassword(bot.password())
                .clickSubmit();
    }
}
