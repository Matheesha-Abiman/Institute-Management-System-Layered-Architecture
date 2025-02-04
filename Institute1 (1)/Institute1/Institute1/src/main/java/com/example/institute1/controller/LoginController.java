package com.example.institute1.controller;

import com.example.institute1.BO.LoginBOImpl;
import com.example.institute1.BO.custom.LoginBOInterface;
import com.example.institute1.crud.CrudUtil;

import com.example.institute1.entity.Admin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final LoginBOInterface loginBO = new LoginBOImpl();

    @FXML
    private Label forgotpassTf;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label lblDateTime;

    @FXML
    private JFXPasswordField passwordTf;

    @FXML
    private JFXTextField usernameTf;

    @FXML
    private Label lblPercentage;

    @FXML
    private Rectangle rctMain;

    @FXML
    private Rectangle rctSub;

    private static String AES_KEY = "your_secret_key";

    private void initializeDateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd || HH:mm:ss");
            lblDateTime.setText(LocalDateTime.now().format(formatter));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    void clickForgotPass(MouseEvent event) throws IOException {
        System.out.println("Forgot Password clicked.");
        Parent root = FXMLLoader.load(getClass().getResource("/view/forgotpass.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    void clickLoginBtn(ActionEvent event) {
        String email = usernameTf.getText();
        String password = passwordTf.getText();

        try {
            Admin admin = loginBO.validateLogin(email, password);

            if (admin != null) {
                System.out.println("Valid Login");

                Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Invalid Login: Incorrect credentials");
                new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Database Error").show();
        }
    }

    @FXML
    void enterPassword(ActionEvent event) throws IOException {
        clickLoginBtn(event);
    }

    @FXML
    void enterUsername(ActionEvent event) {
        passwordTf.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeDateTime();
    }
}
