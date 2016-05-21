package ru.hokan.controllers.hadnlers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import ru.hokan.controllers.ContactController;
import ru.hokan.controllers.MessageDialogController;
import ru.hokan.util.I18N;
import ru.hokan.views.ViewsHolder;

import java.io.IOException;

public class SendMessageButtonEventHandler implements EventHandler<MouseEvent> {

    private static final Logger LOGGER = Logger.getLogger(SendMessageButtonEventHandler.class);

    /**
     * {@inheritDoc}
     */
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
            // TODO messy hack, try to avoid
            ContactController contactController = ViewsHolder.INSTANCE.getController("contact.fxml");
            controller.setUser(contactController.getUser());

            // TODO here you can hide current window and restore, after closing
            // current dialog, but it will only be nice, if you have per-one-dialog application
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
