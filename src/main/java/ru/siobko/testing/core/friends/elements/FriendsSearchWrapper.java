package ru.siobko.testing.core.friends.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FriendsSearchWrapper implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(FriendsSearchWrapper.class);

    private static final By FRIENDS_SEARCH_FIELD = byXpath(".//*[@placeholder='Искать друзей']");
    private static final By SEARCH_ICON = byXpath(".//*[contains(@name,'ico_search')]");

    public FriendsSearchWrapper() {
        check();
        log.info("Отркылся расширенный поисковик по друзьям(и не только)");
    }

    @Override
    public void check() throws Error {
        $(FRIENDS_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода поисковика"));
        $(SEARCH_ICON).shouldBe(
                visible.because("Не отобразилась иконка поиска(лупа)"));
    }

    public FriendsSearchWrapper setText(String text) {
        $(FRIENDS_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода поисковика")
        ).setValue(text);
        return this;
    }

    public void clikcOnSearchIcon() {
        $(SEARCH_ICON).shouldBe(
                visible.because("Не отобразилась иконка поиска(лупа)")
        ).click();
    }
}
