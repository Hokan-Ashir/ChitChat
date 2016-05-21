package ru.hokan;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.hokan.controllers.ContactListController;
import ru.hokan.impl.UserListModelImpl;
import ru.hokan.util.I18N;
import ru.hokan.views.ViewsHolder;

import java.util.Locale;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = ViewsHolder.INSTANCE.getView("contactList.fxml");
        I18N.INSTANCE.loadBundleMessages("messages", Locale.getDefault());
        primaryStage.setTitle(I18N.INSTANCE.getMessage("contact.list.window.caption"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        ContactListController controller = ViewsHolder.INSTANCE.getController("contactList.fxml");
        controller.updateUserListWithModel(new UserListModelImpl());
    }
}

