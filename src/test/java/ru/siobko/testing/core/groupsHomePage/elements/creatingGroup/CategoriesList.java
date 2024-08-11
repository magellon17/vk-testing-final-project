package ru.siobko.testing.core.groupsHomePage.elements.creatingGroup;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.models.group.GroupTopic;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoriesList extends CreateGroupForm implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(CategoriesList.class);

    private static final By CARS_CATEGORY_BUTTON = byXpath(".//*[text()='Автомобили']");
    private static final By CAR_WOSH_CATEGORY_BUTTON = byXpath(".//*[text()='Автомойка']");

    public CategoriesList() {
        check();
    }

    @Override
    public void check() {
        $(CAR_WOSH_CATEGORY_BUTTON).shouldBe(
                visible.because(""));
        $(CARS_CATEGORY_BUTTON).shouldBe(
                visible.because(""));
    }

    public CreateGroupForm selectGroupCategory(GroupTopic topic) {
        log.info("Выбираем тематику группы");
        switch (topic) {
            case CARS:
                $(CARS_CATEGORY_BUTTON).shouldBe(
                        visible.because("Автомобильной тематики нет в списке.")
                ).click();
                break;
            case CAR_WASH:
                $(CAR_WOSH_CATEGORY_BUTTON).shouldBe(
                        visible.because("Нет варианта создать группу по интересам.")
                ).click();
        }
        return this;
    }
}
