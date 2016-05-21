package ru.hokan.controllers;

import com.tassta.test.chat.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.hokan.controllers.hadnlers.EventHandlersHolder;
import ru.hokan.controllers.hadnlers.SendMessageButtonEventHandler;
import ru.hokan.controllers.hadnlers.ShowMessageHistoryButtonEventHandler;

public class ContactController {

    private User user;

    @FXML
    private Button showHistoryButton;

    @FXML
    private Button sendMessageButton;

    @FXML
    private ImageView userImage;

    @FXML
    private TitledPane userPanel;

    @FXML
    public void initialize() {
        EventHandler sendMessageHandler = EventHandlersHolder.INSTANCE.getEventHandler(SendMessageButtonEventHandler.class);
        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, sendMessageHandler);

        EventHandler showHistoryHandler = EventHandlersHolder.INSTANCE.getEventHandler(ShowMessageHistoryButtonEventHandler.class);
        showHistoryButton.addEventHandler(MouseEvent.MOUSE_CLICKED, showHistoryHandler);
    }

    public void setUserIcon(Image icon) {
        this.userImage.setImage(icon);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
