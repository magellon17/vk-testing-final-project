package ru.siobko.testing.core.groupsHomePage.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.models.group.GroupType;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ChooseGroupTypeDialog implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(ChooseGroupTypeDialog.class);

    private static final By GROUP_BY_INTEREST_BUTTON = byXpath(".//a[@data-l='t,INTEREST']");
    private static final By BUSINESS_GROUP_BUTTON = byXpath(".//a[@data-l='t,PAGE']");
    private static final By EVENT_BUTTON = byXpath(".//a[@data-l='t,HAPPENING']");

    public ChooseGroupTypeDialog() {
        check();
    }

    @Override
    public void check() throws Error {
        $(GROUP_BY_INTEREST_BUTTON).shouldBe(
                visible.because("НЕ нашел"));
        $(BUSINESS_GROUP_BUTTON).shouldBe(
                visible.because("НЕ нашел"));
        log.info("");
    }

    public CreateGroupForm selectGroupType(GroupType groupType) {
        log.info("Выбираем {} группу", groupType);
        switch (groupType) {
            case BY_INTERESTS:
                $(GROUP_BY_INTEREST_BUTTON).shouldBe(
                        visible.because("Нет варианта создать группу по интересам")
                ).click();
                break;
            case BUSINESS:
                $(BUSINESS_GROUP_BUTTON).shouldBe(
                        visible.because("Нет варианта создать бизнес группу")
                ).click();
                break;
            case EVENT:
                $(EVENT_BUTTON).shouldBe(
                        visible.because("Нет варианта создать событие")
                ).click();
        }
        return new CreateGroupForm();
    }


}
