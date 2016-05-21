package ru.hokan.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public enum ViewsHolder {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ViewsHolder.class);

    Map<String, ViewTuple> views = new HashMap<>();

    public Parent getView(String viewFileName) {
        ViewTuple existedParent = views.get(viewFileName);
        if (existedParent != null) {
            return existedParent.getView();
        }

        FXMLLoader loader = new FXMLLoader();
        Parent parent = loadNewView(viewFileName, loader);

        Object controller = loader.getController();
        ViewTuple tuple = new ViewTuple(parent, controller);
        views.put(viewFileName, tuple);
        return parent;
    }

    public <T> T getController(String viewFileName) {
        ViewTuple existedParent = views.get(viewFileName);
        if (existedParent != null) {
            return existedParent.getController();
        }

        FXMLLoader loader = new FXMLLoader();
        Parent parent = loadNewView(viewFileName, loader);

        Object controller = loader.getController();
        ViewTuple tuple = new ViewTuple(parent, controller);
        views.put(viewFileName, tuple);
        return (T) controller;
    }

    private Parent loadNewView(String viewFileName, FXMLLoader loader) {
        loader.setLocation(getClass().getClassLoader().getResource(viewFileName));
        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException("Impossible to load view file " + viewFileName);
        }
        return parent;
    }
}
