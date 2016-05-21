package ru.hokan.impl;

import com.tassta.test.chat.MessageHistoryModel;

public enum MessageHistoryModelHolder {
    INSTANCE;

    private MessageHistoryModel model = new MessageHistoryModelImpl();

    public MessageHistoryModel getModel() {
        return model;
    }
}
