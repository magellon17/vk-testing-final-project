package ru.siobko.testing.tests.groups;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.groupPage.OwnGroupPage;
import ru.siobko.testing.core.groupsHomePage.GroupsHomePage;
import ru.siobko.testing.core.homePage.HomePage;
import ru.siobko.testing.models.group.Group;
import ru.siobko.testing.models.group.GroupTopic;
import ru.siobko.testing.models.group.GroupType;
import ru.siobko.testing.tests.RequiredLoginTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckNameAndTopicAfterGroupCreationTest extends RequiredLoginTest {

    private static final Logger log = LoggerFactory.getLogger(CheckNameAndTopicAfterGroupCreationTest.class);

    private static final Group group =
            new Group(GroupType.BY_INTERESTS, GroupTopic.CARS, RandomString.make(10));

    @BeforeAll
    public static void openGroupsHomePage() {
        log.info("Откроем страницу с группами.");
        new HomePage().goToGroupsPage();
    }

    @Test
    public void checkNameAndTopicAfterGroupCreationTest() {
        log.info("Создаем группу.");
        OwnGroupPage ownGroupMainPage = new GroupsHomePage()
                .clickCreateGroup()
                .selectGroupType(group.type())
                .enterGroupName(group.name())
                .expandCategoriesList()
                .selectGroupCategory(group.topic())
                .clickCreate();
        assertAll(
                "Проверка названия и категории группы",
                () -> assertEquals(ownGroupMainPage.getGroupName(), group.name(),
                        "Название группы не совпало с ожидаемым."),
                () -> assertEquals(ownGroupMainPage.getGroupTopic(), group.topic().toString(),
                        "Категория группы не совпала с ожидаемым.")
        );
    }

    @AfterEach
    public void removeCreatedGroup() {
        log.info("Удаляем созданную группу");
        new OwnGroupPage()
                .dropdownActionsMenu()
                .clickOnDelete()
                .confirmDeletion();
    }
}
