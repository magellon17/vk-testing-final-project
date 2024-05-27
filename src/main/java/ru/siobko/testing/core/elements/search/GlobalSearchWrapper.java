package ru.siobko.testing.core.elements.search;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.search.elements.SearchResultUserCardWrapper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GlobalSearchWrapper implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(GlobalSearchWrapper.class);

    private final SelenideElement searchResults = $(byXpath(".//*[contains(@class,'dropdown-results')]"));

    private static final By FRIENDS_SEARCH_FIELD = byXpath(".//*[@placeholder='Искать на сайте']");
    private static final By COLLAPSE_SEARCH = byXpath(".//*[@data-action='collapse']");

    public GlobalSearchWrapper() {
        check();
        log.info("Отркылся расширенный поисковик по сайту");
    }

    @Override
    public void check() throws Error {
        $(FRIENDS_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода поисковика"));
    }

    public GlobalSearchWrapper setText(String text) {
        $(FRIENDS_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразилось поле ввода поисковика")
        ).setValue(text);
        return this;
    }

    public SearchResultUserCardWrapper getUserCardByName(String username) {
        SelenideElement userCard = searchResults.$(byXpath(".//*[contains(text(),'" + username + "')]/../../../../a"));
        return new SearchResultUserCardWrapper(userCard);
    }

    public void collapseSearch() {
        $(COLLAPSE_SEARCH).shouldBe(
                visible.because("Не отобразилась кнопка закрытия поисковика")
        ).click();
    }
}
