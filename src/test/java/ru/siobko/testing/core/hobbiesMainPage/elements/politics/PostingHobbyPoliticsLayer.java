package ru.siobko.testing.core.hobbiesMainPage.elements.politics;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.hobbiesMainPage.elements.posting.notify.PostedHobbyNotifyPromise;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Леер с политикой публикации поста об увлечении
 */
public class PostingHobbyPoliticsLayer implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(PostingHobbyPoliticsLayer.class);

    private final SelenideElement layer = $(byXpath(".//*[@data-modal-name='HobbyInfoModal']"));

    private static final By CLOSE_LAYER = byText("Закрыть");
    private static final By TITLE = byText("Публикация в раздел Увлечения");

    public PostingHobbyPoliticsLayer(){
        check();
        log.info("Загрузился леер политики публикации увлечения");
    }

    @Override
    public void check() throws Error {
        layer.$(TITLE).shouldBe(
                visible.because("Не отобразилась кнопка закрытия леера"));
    }

    public PostedHobbyNotifyPromise closeLayer() {
        layer.$(CLOSE_LAYER).shouldBe(
                visible.because("Не отобразилась кнопка закрытия леера")
        ).click();
        return new PostedHobbyNotifyPromise();
    }
}
