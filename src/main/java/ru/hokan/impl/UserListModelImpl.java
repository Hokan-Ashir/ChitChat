package ru.hokan.impl;

import com.tassta.test.chat.User;
import com.tassta.test.chat.UserListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserListModelImpl implements UserListModel {

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableList<User> getUserList() {
        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new UserImpl("Jay", 1, true));
        users.add(new UserImpl("Silent Bob", 2, false));
        users.add(new UserImpl("Mr. Anderson", 3, true));
        users.add(new UserImpl("Neo", 4, false));

        return users;
    }
}
