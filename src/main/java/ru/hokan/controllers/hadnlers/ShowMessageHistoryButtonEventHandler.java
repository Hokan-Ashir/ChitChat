package ru.hokan.controllers.hadnlers;

import com.tassta.test.chat.MessageHistory;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.hokan.controllers.ContactController;
import ru.hokan.controllers.MessageHistoryController;
import ru.hokan.impl.MessageHistoryModelHolder;
import ru.hokan.util.I18N;
import ru.hokan.views.ViewsHolder;

public class ShowMessageHistoryButtonEventHandler implements EventHandler<MouseEvent> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void handle(MouseEvent event) {
        showMessageHistoryView();
    }

    private void showMessageHistoryView() {
        Parent root = ViewsHolder.INSTANCE.getView("messageHistory.fxml");
        Stage stage = new Stage();
        stage.setTitle(I18N.INSTANCE.getMessage("message.history.window.caption"));
        Scene scene = root.getScene();
        if (scene != null) {
            stage.setScene(scene);
        } else {
            scene = new Scene(root, 450, 450);
        }
        stage.setScene(scene);
        stage.show();

        ContactController contactController = ViewsHolder.INSTANCE.getController("contact.fxml");
        MessageHistoryController controller = ViewsHolder.INSTANCE.getController("messageHistory.fxml");
        MessageHistory messageHistory = MessageHistoryModelHolder.INSTANCE.getModel().getMessageHistory(contactController.getUser());
        controller.updateHistoryWithModel(messageHistory);

        // TODO here you can hide current window and restore, after closing
        // current dialog, but it will only be nice, if you have per-one-dialog application
    }
}
