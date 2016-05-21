package ru.hokan.views;

import javafx.scene.Parent;

public class ViewTuple {
    private Parent view;
    private Object controller;

    public ViewTuple(Parent view, Object controller) {
        this.view = view;
        this.controller = controller;
    }

    public Parent getView() {
        return view;
    }

    public <T> T getController() {
        return (T) controller;
    }
}
