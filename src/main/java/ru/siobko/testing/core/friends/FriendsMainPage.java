package ru.siobko.testing.core.friends;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.SideNavigationBlock;
import ru.siobko.testing.core.friends.elements.FriendsSearchWideContainer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FriendsMainPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(FriendsMainPage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By FRIENDS_SEARCH_CONTAINER = byXpath(".//*[contains(@class, 'search-container')]");

    public FriendsMainPage() {
        check();
        log.info("Перешли на главную страницу друзей");
    }

    @Override
    public void check() throws Error {
        $(FRIENDS_SEARCH_CONTAINER).shouldBe(
                visible.because("Не отобразился поисковик по друзьям(и не только)"));
    }

    public FriendsSearchWideContainer expandSearchContainer() {
        log.info("Раскрываем поисковик по друзьям(и не только)");
        $(FRIENDS_SEARCH_CONTAINER).shouldBe(
                visible.because("Не отобразился поисковик по друзьям(и не только)")
        ).click();
        return new FriendsSearchWideContainer();
    }
}