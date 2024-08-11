package ru.siobko.testing.tests.hobbies;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.siobko.testing.core.hobbiesMainPage.HobbiesPage;
import ru.siobko.testing.models.hobby.Hobby;
import ru.siobko.testing.models.hobby.HobbyCategory;
import ru.siobko.testing.tests.RequiredLoginTest;
import ru.siobko.testing.tests.hobbies.steps.CheckPostedHobbyNotifyDisplayingSteps;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CheckPostedHobbyNotifyDisplayingTest extends RequiredLoginTest {

    private final CheckPostedHobbyNotifyDisplayingSteps steps =
            new CheckPostedHobbyNotifyDisplayingSteps();

    private static final Hobby hobby = new Hobby(HobbyCategory.PETS, RandomString.make(10));

    @BeforeEach
    public void beforeTest() {
        steps.openHobbiesPage();
    }

    @ParameterizedTest(name = "Увлечение: {0}")
    @ArgumentsSource(HobbiesParams.class)
    public void testGroupCreation(Hobby hobby) {
        steps.postHobby(hobby);
        assertTrue(new HobbiesPage().isPublishedPostNotifyDisplayed(),
                "Не отобразилось уведомление об опубликованном посте об увлечении");
    }

    @AfterEach
    public void afterTest() {
        steps.openPostedHobby();
        steps.deletePostedHobbyTopic();
    }

    static class HobbiesParams implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(hobby)
            );
        }
    }
}
