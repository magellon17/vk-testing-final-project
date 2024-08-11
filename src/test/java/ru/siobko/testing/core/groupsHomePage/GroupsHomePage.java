package ru.siobko.testing.core.groupsHomePage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.groupsHomePage.elements.creatingGroup.ChooseGroupTypeDialog;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsHomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(GroupsHomePage.class);

    private static final By GROUP_SEARCH_FIELD = byXpath(".//group-search-input[@data-bundle-name='search_group-search-input']");
    private static final By CREATE_GROUP_BUTTON = byText("Создать группу");

    public GroupsHomePage() {
        check();
    }

    @Override
    public void check() throws Error {
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы")
        );
        $(GROUP_SEARCH_FIELD).shouldBe(
                visible.because("Не отобразился поисковик по группам")
        );
    }

    public ChooseGroupTypeDialog clickCreateGroup() {
        log.info("Кликаем на кнопку создания группы.");
        $(CREATE_GROUP_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка создания группы.")
        ).click();
        return new ChooseGroupTypeDialog();
    }
}
