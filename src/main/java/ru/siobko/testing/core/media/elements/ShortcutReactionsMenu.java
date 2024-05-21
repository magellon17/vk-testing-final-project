package ru.siobko.testing.core.media.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ShortcutReactionsMenu implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(ShortcutReactionsMenu.class);

    private final SelenideElement menu = $(byXpath(".//*[@id='hook_Block_ShortcutMenuReact']"));

    private static final By PRIVATE_KLASS_REACTION = byXpath(".//*[@title='Класс! (Приватная эмоция)']");
    private static final By SUPER_REACTION = byXpath(".//*[@title='Супер']");

    public ShortcutReactionsMenu() {
        isLoaded();
        log.info("Отобразилось меню реакций");
    }

    @Override
    public void isLoaded() throws Error {
        menu.$(SUPER_REACTION).shouldBe(
                visible.because("Не отобразилась реакция 'Класс'"));
        menu.$(PRIVATE_KLASS_REACTION).shouldBe(
                visible.because("Не отобразилась реакция 'Класс'"));
    }

    public void setSuper() {
        menu.$(SUPER_REACTION).shouldBe(
                visible.because("Не отобразилась реакция 'Класс'")
        ).click();
    }
}
