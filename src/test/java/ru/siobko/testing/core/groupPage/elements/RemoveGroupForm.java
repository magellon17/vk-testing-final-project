package ru.siobko.testing.core.groupPage.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.groupsHomePage.GroupsHomePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RemoveGroupForm {

    private static final Logger log = LoggerFactory.getLogger(RemoveGroupForm.class);

    private static final By CONFIRM_DELETION_BUTTON = byXpath(".//*[@data-l='t,confirm']");

    public GroupsHomePage confirmDeletion() {
        log.info("Подтверждаем удаление группы.");
        $(CONFIRM_DELETION_BUTTON).shouldBe(
                visible.because("Не появилась кнопка пожтверждения удаления.")
        ).click();
        return new GroupsHomePage();
    }
}
