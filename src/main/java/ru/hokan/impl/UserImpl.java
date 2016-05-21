package ru.hokan.impl;

import com.tassta.test.chat.User;
import javafx.scene.image.Image;

public class UserImpl implements User {

    private String name;
    private int id;
    private boolean isOnline;
    private Image icon;

    public UserImpl(String name, int id, boolean isOnline) {
        this.name = name;
        this.id = id;
        this.isOnline = isOnline;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOnline() {
        return isOnline;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getIcon() {
        return icon;
    }

    private void setIcon(boolean isOnline) {
        if (isOnline) {
            icon = new Image("@icons/user_online.png");
        } else {
            icon = new Image("@icons/user_offline.png");
        }
    }
}
