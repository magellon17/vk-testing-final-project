package ru.siobko.testing.core.main.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.main.elements.SideNavigationBlock;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MyUserMainPage {

    private static final Logger log = LoggerFactory.getLogger(MyUserMainPage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By FEED_WRAPPER = byId("hook_Block_MainFeedsWrapper");

    public MyUserMainPage() {
        checkPage();
    }

    public boolean checkPage() {
        $(FEED_WRAPPER).shouldBe(
                visible.because("Не отобразилась лента пользователя"));
        return true;
    }
}
