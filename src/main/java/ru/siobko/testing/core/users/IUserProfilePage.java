package ru.siobko.testing.core.users;

import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.users.myUser.elements.UserProfileMoreActionMenu;

public interface IUserProfilePage extends UIComponent {
    UserProfileMoreActionMenu expandMoreActionsMenu();
}
