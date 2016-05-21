package ru.hokan.controllers.hadnlers;

import javafx.event.EventHandler;

import java.util.HashMap;
import java.util.Map;

public enum EventHandlersHolder {
    INSTANCE;

    private Map<Class<? extends EventHandler>, EventHandler> handlers = new HashMap<Class<? extends EventHandler>, EventHandler>() {{
        put(SendMessageButtonEventHandler.class, new SendMessageButtonEventHandler());
        put(ShowMessageHistoryButtonEventHandler.class, new SendMessageButtonEventHandler());
    }};

    public EventHandler getEventHandler(Class<? extends EventHandler> handlerClass) {
        EventHandler handler = handlers.get(handlerClass);
        if (handler == null) {
            throw new RuntimeException("There is no event handler for " + handlerClass.getName() + " in " + getClass().getName());
        }

        return handler;
    }
}
