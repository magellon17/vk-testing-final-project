package ru.siobko.testing.core.groupPage.members;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.groupPage.GroupPage;
import ru.siobko.testing.core.groupPage.OwnGroupPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class OwnGroupMembersPage extends GroupMembersPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(OwnGroupMembersPage.class);

    private static final By TODO_BLOCK = byId("groupTODO");

    public OwnGroupMembersPage() {
        check();
    }

    @Override
    public void check() {
        $(TODO_BLOCK).shouldBe(
                visible.because(""));
        log.info("Перешли на страницу участников группы.");
    }

    @Override
    public GroupPage openGroupMainPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnFeed();
        return new OwnGroupPage();
    }
}
