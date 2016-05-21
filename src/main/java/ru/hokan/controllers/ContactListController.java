package ru.hokan.controllers;

import com.tassta.test.chat.User;
import com.tassta.test.chat.UserListModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import ru.hokan.views.ViewsHolder;

public class ContactListController {

    private UserListModel userListModel;

    @FXML
    private Accordion usersAccordion;

    @FXML
    public void initialize() {
        usersAccordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {

            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldValue, TitledPane newValue) {
                if (newValue == null) {
                    return;
                }

                String userName = newValue.getText();
                Parent view = ViewsHolder.INSTANCE.getView("contact.fxml");
                if (newValue.equals(view)) {
                    return;
                }

                TitledPane pane = (TitledPane) view;
                setContactPaneAndExpand(newValue, pane);
                pane.setText(userName);

                ContactController controller = ViewsHolder.INSTANCE.getController("contact.fxml");
                User user = getUserByName(userName);
                controller.setUser(user);
                controller.setUserIcon(user.getIcon());
            }
        });
    }

    private void setContactPaneAndExpand(TitledPane newValue, TitledPane pane) {
        ObservableList<TitledPane> panes = usersAccordion.getPanes();
        findAndReplaceOldContactPaneWithStubPane(pane, panes);

        int i = panes.indexOf(newValue);
        panes.set(i, pane);
        panes.get(i).setExpanded(true);
    }

    private void findAndReplaceOldContactPaneWithStubPane(TitledPane pane, ObservableList<TitledPane> panes) {
        for (int i = 0; i < panes.size(); ++i) {
            TitledPane innerPane = panes.get(i);
            String text = pane.getText();
            if (innerPane.getText().equals(text)) {
                TitledPane stubPane = new TitledPane();
                stubPane.setText(text);
                panes.set(i, stubPane);
                break;
            }
        }
    }

    public void updateUserListWithModel(UserListModel userListModel) {
        this.userListModel = userListModel;
        ObservableList<TitledPane> panes = usersAccordion.getPanes();
        panes.clear();
        for (User user : userListModel.getUserList()) {
            TitledPane pane = new TitledPane();
            pane.setText(user.getName());
            panes.add(pane);
        }
    }

    private User getUserByName(String userName) {
        for (User user : userListModel.getUserList()) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }

        return null;
    }
}
