package ru.siobko.testing.core.elements.sideNavigation.promises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.friends.FriendsMainPage;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.users.myUser.MyUserProfilePage;

import static com.codeborne.selenide.Selenide.$;

public class PagesNavigationPromise {

    private static final Logger log = LoggerFactory.getLogger(PagesNavigationPromise.class);

    public HomePage andWaitHomePage() {
        log.info("Ожидаем открытия главной страницы");
        return new HomePage();
    }

    public MyUserProfilePage andWaitProfilePage() {
        log.info("Ожидаем открытия страницы профиля текущего пользователя");
        return new MyUserProfilePage();
    }

    public FriendsMainPage andWaitFriendsPage() {
        log.info("Ожидаем открытия страницы друзей текущего пользователя");
        return new FriendsMainPage();
    }
}
