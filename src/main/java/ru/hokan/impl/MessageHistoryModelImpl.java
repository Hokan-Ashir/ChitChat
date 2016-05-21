package ru.hokan.impl;

import com.tassta.test.chat.MessageHistory;
import com.tassta.test.chat.MessageHistoryModel;
import com.tassta.test.chat.User;

import java.util.HashMap;
import java.util.Map;

public class MessageHistoryModelImpl implements MessageHistoryModel {

    private Map<Integer, MessageHistory> historyMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public MessageHistory getMessageHistory(User user) {
        MessageHistory history = historyMap.get(user.getId());
        if (history == null) {
            history = new MessageHistoryImpl();
            historyMap.put(user.getId(), history);
        }

        return history;
    }
}
