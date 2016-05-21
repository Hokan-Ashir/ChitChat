package ru.hokan.impl;

import com.tassta.test.chat.Message;
import com.tassta.test.chat.User;

import java.util.Date;

public class MessageImpl implements Message {

    private final Date date;
    private final String text;
    private final User sender;
    private final User receiver;

    public MessageImpl(Date date, String text, User sender, User receiver) {
        this.date = date;
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date getDate() {
        return date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getSender() {
        return sender;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getReceiver() {
        return receiver;
    }
}
