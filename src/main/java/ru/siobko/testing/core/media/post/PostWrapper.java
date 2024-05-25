package ru.siobko.testing.core.media.post;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.media.elements.ShortcutReactionsMenu;
import ru.siobko.testing.core.media.post.elements.PostActionsMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;

/**
 * Обертка над постом
 */
public class PostWrapper {

    private static final Logger log = LoggerFactory.getLogger(PostWrapper.class);

    private final SelenideElement post;

    private static final By REACTIONS_BTN = byXpath(".//*[@aria-label='Поставить класс']");
    private static final By REMOVE_REACTION_BTN = byXpath(".//*[@aria-label='Снять класс']");
    private static final By EXPAND_ACTIONS_MENU = byClassName("feed-action");

    public PostWrapper(SelenideElement postElement) {
        post = postElement;
    }

    public ShortcutReactionsMenu expandReactionsListMenu() {
        log.info("Открываем меню реакций");
        post.$(REACTIONS_BTN).shouldBe(
                visible.because("Не отобразилась кнопка 'Класс'")
        ).hover();
        return new ShortcutReactionsMenu();
    }

    public boolean isReactionSet() {
        return post.$(REMOVE_REACTION_BTN).isDisplayed();
    }

    public void setKlass() {
        post.$(REACTIONS_BTN).shouldBe(
                visible.because("Не отобразилась кнопка 'Класс'")
        ).click();
    }

    public PostActionsMenu expandActionsMenu() {
        post.$(EXPAND_ACTIONS_MENU).shouldBe(
                visible.because("Не отобразились 3 точки поста")
        ).click();
        return new PostActionsMenu();
    }
}
