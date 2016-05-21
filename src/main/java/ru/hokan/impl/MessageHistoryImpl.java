package ru.hokan.impl;

import com.tassta.test.chat.Message;
import com.tassta.test.chat.MessageHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MessageHistoryImpl implements MessageHistory {

    private ObservableList<Message> messages = FXCollections.observableArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableList<Message> getMessageList() {
        return messages;
    }
}
