package ru.hokan.controllers;

import com.tassta.test.chat.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.apache.log4j.Logger;
import ru.hokan.UserHolder;
import ru.hokan.impl.IoManagerImpl;
import ru.hokan.util.I18N;

import java.util.Date;

public class MessageDialogController {

    private static final Logger LOGGER = Logger.getLogger(MessageDialogController.class);

    private ContactListController contactListController;

    @FXML
    private TextArea inputMessageTextArea;

    @FXML
    private TextArea chatMessagesTextArea;

    @FXML
    public void initialize() {
        inputMessageTextArea.requestFocus();
        inputMessageTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!(event.isControlDown() && event.getCode().equals(KeyCode.ENTER))) {
                    return;
                }

                String text = inputMessageTextArea.getText();
                if (text.isEmpty()) {
                    String infoMessage = I18N.INSTANCE.getMessage("nothing.to.send.info.message");
                    LOGGER.info(infoMessage);
                    return;
                }

                sendMessage(text);

                Date date = new Date();
                updateChatMessagesText(text, date);
                inputMessageTextArea.clear();
            }
        });
    }

    private void sendMessage(String text) {
        User receiver = contactListController.getUser();
        try {
            IoManagerImpl.INSTANCE.sendMessage(receiver, text);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void updateChatMessagesText(String text, Date date) {
        User sender = UserHolder.INSTANCE.getUser();
        String chatMessages = chatMessagesTextArea.getText();
        chatMessages += sender.getName() + " (" + date.toString() + "): " + text + "\n";
        chatMessagesTextArea.setText(chatMessages);
    }

    public void setContactListController(ContactListController contactListController) {
        this.contactListController = contactListController;
    }
}