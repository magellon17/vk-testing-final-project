package ru.siobko.testing.core.groupPage.members;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.groupPage.GroupPage;
import ru.siobko.testing.core.groupPage.elements.GroupNavigationMenu;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class GroupMembersPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(GroupMembersPage.class);

    protected final GroupNavigationMenu groupNavigation = new GroupNavigationMenu();

    protected static final By MEMBERS_BLOCK = byId("listBlockPanelGroupMembersPagingBlock");

    public GroupMembersPage() {
        check();
    }

    @Override
    public void check() throws Error {
        $(MEMBERS_BLOCK).shouldBe(
                visible.because(""));
        log.info("Перешли на страницу участников группы");
    }

    public GroupPage openGroupMainPage() {
        log.info("Открываем страницу фоток группы");
        groupNavigation.clickOnFeed();
        return new GroupPage();
    }
}
