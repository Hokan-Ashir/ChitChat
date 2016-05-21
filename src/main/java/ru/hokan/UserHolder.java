package ru.hokan;

import com.tassta.test.chat.User;
import ru.hokan.impl.UserImpl;

public enum UserHolder {
    INSTANCE;

    private final User user;

    UserHolder() {
        user = new UserImpl("Me", 0, true);
    }

    public User getUser() {
        return user;
    }
}
