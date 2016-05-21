package ru.hokan.controllers;

import com.tassta.test.chat.User;
import com.tassta.test.chat.UserListModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import ru.hokan.impl.UserImpl;
import ru.hokan.util.I18N;

import java.io.IOException;

public class ContactListController {

    private static final Logger LOGGER = Logger.getLogger(ContactListController.class);

    private UserListModel userListModel;

    @FXML
    private Accordion usersAccordion;

    @FXML
    private TitledPane userPanel;

    @FXML
    private ImageView userImage;

    @FXML
    private Button sendMessageButton;

    @FXML
    private Button showHistoryButton;

    @FXML
    public void initialize() {
        attachShowMessageHistoryButtonListener();
        attachSendMessageButtonListener();
    }

    private void attachShowMessageHistoryButtonListener() {
        showHistoryButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                showMessageHistoryView();
            }

            private void showMessageHistoryView() {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("messageHistory.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle(I18N.INSTANCE.getMessage("message.history.window.caption"));
                    stage.setScene(new Scene(root, 450, 300));
                    stage.show();

                    // TODO here you can hide current window and restore, after closing
                    // current dialog, but it will only be nice, if you have per-one-dialog application
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        });
    }

    private void attachSendMessageButtonListener() {
        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                showMessageDialogView();
            }

            private void showMessageDialogView() {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getClassLoader().getResource("messageDialog.fxml"));
                    root = loader.load();
                    Stage stage = new Stage();
                    stage.setTitle(I18N.INSTANCE.getMessage("message.dialog.window.caption"));
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();

                    MessageDialogController controller = loader.getController();
                    controller.setContactListController(ContactListController.this);

                    // TODO here you can hide current window and restore, after closing
                    // current dialog, but it will only be nice, if you have per-one-dialog application
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        });
    }

    public User getUser() {
        return new UserImpl("someName", 1, true);
    }
}
