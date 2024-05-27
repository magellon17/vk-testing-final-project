package ru.siobko.testing.core.hobbies.elements.posting.postingForm.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.hobbies.elements.posting.postingForm.PostingHobbyForm;
import ru.siobko.testing.models.hobby.HobbyCategory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HobbyCategoriesMenu implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(HobbyCategoriesMenu.class);

    private final SelenideElement menu = $(byXpath(".//*[@data-testid='ddm-menu']"));

    private static final By COOKING_BTN = byText("Кулинария");
    private static final By PETS_BTN = byText("Питомцы");

    public HobbyCategoriesMenu() {
        check();
        log.info("Загрузилось меню выбора категории увлечения");
    }

    @Override
    public void check() throws Error {
        menu.$(PETS_BTN).shouldBe(
                visible.because("Не отобразтилась кнопка 'Питомцы'"));
    }

    public PostingHobbyForm selectCategory(HobbyCategory hobbyCategory) {
        switch (hobbyCategory) {
            case COOKING:
                menu.$(COOKING_BTN).shouldBe(
                        visible.because("Не отобразтилась кнопка 'Кулинария'")
                ).click();
                break;
            case PETS:
                menu.$(PETS_BTN).shouldBe(
                        visible.because("Не отобразтилась кнопка 'Питомцы'")
                ).click();
        }
        return new PostingHobbyForm();
    }
}
