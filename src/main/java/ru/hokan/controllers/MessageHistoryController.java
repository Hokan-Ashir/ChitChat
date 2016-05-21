package ru.hokan.controllers;

import com.tassta.test.chat.Message;
import com.tassta.test.chat.MessageHistory;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MessageHistoryController {

    @FXML
    private TextArea messageHistory;

    public void updateHistoryWithModel(MessageHistory historyModel) {
        messageHistory.clear();
        StringBuilder builder = new StringBuilder();
        for (Message message : historyModel.getMessageList()) {
            builder.append(message.getSender().getName()).append(" (").append(message.getDate()).append("): ").append(message.getText()).append("\n");
        }

        messageHistory.setText(builder.toString());
    }
}
