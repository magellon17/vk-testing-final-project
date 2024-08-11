package ru.siobko.testing.core.groupPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.groupPage.members.GroupMembersPage;
import ru.siobko.testing.core.groupPage.members.OwnGroupMembersPage;
import ru.siobko.testing.core.groupPage.photos.GroupPhotosPage;
import ru.siobko.testing.core.groupPage.photos.OwnGroupPhotosPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OwnGroupPage extends GroupPage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(OwnGroupPage.class);

    private static final By PROMOTE_BUTTON = byText("Продвинуть");

    public OwnGroupPage() {
        check();
    }

    @Override
    public void check() {
        $(PROMOTE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка 'Продвинуть'."));
        log.info("Перешли на страницу ленты группы");
    }

    @Override
    public GroupMembersPage openGroupMembersPage() {
        log.info("Открываем страницу участников группы");
        groupNavigation.clickOnMembers();
        return new OwnGroupMembersPage();
    }

    @Override
    public GroupPhotosPage openGroupPhotosPage() {
        log.info("Открываем страницу фотографий группы");
        groupNavigation.clickOnPhotos();
        return new OwnGroupPhotosPage();
    }

    public String getGroupName() {
        return $(GROUP_NAME).shouldBe(
                visible.because("Не отобразилось название группы.")
        ).getText();
    }

    public String getGroupTopic() {
        return $(GROUP_TOPIC).shouldBe(
                visible.because("Не отобразилась категория группы")
        ).getText();
    }
}
