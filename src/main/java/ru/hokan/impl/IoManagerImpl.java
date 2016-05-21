package ru.hokan.impl;

import com.tassta.test.chat.Message;
import com.tassta.test.chat.User;
import com.tassta.test.chat.UserStateChangeHandler;
import com.tassta.test.chat.noimpl.IoManger;
import org.apache.log4j.Logger;

import java.util.function.Consumer;

public enum IoManagerImpl implements IoManger {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(IoManagerImpl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(User receiver, String text) throws Exception {
        LOGGER.info("Send message \'" + text + "\' to " + receiver.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRecieveMessageHandler(Consumer<Message> handler) {
        LOGGER.info("Set receive manager handler: " + handler.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserStateChangeHandler(UserStateChangeHandler handler) {
        LOGGER.info("Set user state change handler: " + handler.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserAddedHandler(Consumer<User> handler) {
        LOGGER.info("Set user added handler: " + handler.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUserRemovedHandler(int userId) {
        LOGGER.info("Set user removed handler: " + userId);
    }
}
