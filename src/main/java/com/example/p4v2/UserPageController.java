package com.example.p4v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static java.lang.String.valueOf;

public class UserPageController {
    Users currentUser;
    public Label userBalance;
    public void setUser(Users currentUser) {
        this.currentUser = currentUser;
        userBalance.setText("Balance: " + valueOf(currentUser.getBalance()));
    }

    @FXML
    protected void updatePageButtonClick(ActionEvent event) throws IOException {
        //Change stage to user profile when the scene has been made
        Main.showUpdateUserInfoPage(currentUser);
    }

    @FXML
    protected void fillBalencePageButtonClick(ActionEvent event) throws IOException {
        //Change stage to user profile when the scene has been made
        Main.showFillBalence(currentUser);
    }

    @FXML
    protected void statisticsPageButtonClick(ActionEvent event) throws IOException {
        //Change stage to user profile when the scene has been made
        Main.showStatistcsPage(currentUser);
    }

    @FXML
    protected void goBackButtonClick(ActionEvent event) throws IOException {
        //Change stage to user profile when the scene has been made
        Main.showShoppingPage(currentUser);
    }

    public void DeleteButtonClick(ActionEvent actionEvent) throws IOException {
        Main.showPopupDelete(currentUser);
    }
}
