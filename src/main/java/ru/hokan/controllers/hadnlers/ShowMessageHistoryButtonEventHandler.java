package ru.hokan.controllers.hadnlers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import ru.hokan.util.I18N;

import java.io.IOException;

public class ShowMessageHistoryButtonEventHandler implements EventHandler<MouseEvent> {

    private static final Logger LOGGER = Logger.getLogger(ShowMessageHistoryButtonEventHandler.class);

    /**
     * {@inheritDoc}
     */
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
}
