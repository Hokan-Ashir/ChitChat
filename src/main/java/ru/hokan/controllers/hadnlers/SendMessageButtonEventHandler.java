package ru.hokan.controllers.hadnlers;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.hokan.controllers.ContactController;
import ru.hokan.controllers.MessageDialogController;
import ru.hokan.util.I18N;
import ru.hokan.views.ViewsHolder;

public class SendMessageButtonEventHandler implements EventHandler<MouseEvent> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        showMessageDialogView();
    }

    private void showMessageDialogView() {
        Parent root = ViewsHolder.INSTANCE.getView("messageDialog.fxml");
        Stage stage = new Stage();
        stage.setTitle(I18N.INSTANCE.getMessage("message.dialog.window.caption"));
        Scene scene = root.getScene();
        if (scene != null) {
            stage.setScene(scene);
        } else {
            scene = new Scene(root, 450, 450);
        }

        stage.setScene(scene);
        stage.show();

        MessageDialogController controller = ViewsHolder.INSTANCE.getController("messageDialog.fxml");
        // TODO messy hack, try to avoid
        ContactController contactController = ViewsHolder.INSTANCE.getController("contact.fxml");
        controller.setUser(contactController.getUser());

        // TODO here you can hide current window and restore, after closing
        // current dialog, but it will only be nice, if you have per-one-dialog application
    }
}
