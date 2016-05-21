package ru.hokan.impl;

import com.tassta.test.chat.UserListModel;

public enum UserListModelHolder {
    INSTANCE;

    private UserListModel model = new UserListModelImpl();

    public UserListModel getModel() {
        return model;
    }
}
