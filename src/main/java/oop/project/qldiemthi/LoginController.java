package oop.project.qldiemthi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oop.project.qldiemthi.entity.User;
import oop.project.qldiemthi.function.UserFunction;

public class LoginController {
    @FXML
    Button LoginButton;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    private Parent root;


    @FXML
    public void Login(ActionEvent e) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();
        UserFunction userFunction = new UserFunction();
        User user = new User(username, password);
        if(userFunction.checkUser(user)) {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Username or password is not correct !!");
            alert.setContentText("Please check your username and password");
            alert.showAndWait();
        }

    }

    @FXML
    public void LoginEntered(ActionEvent e) throws Exception {
        LoginButton.setBackground(Background.fill(Color.rgb(255,255,255)));
        LoginButton.setTextFill(Color. rgb(0, 153, 255));

    }

    @FXML
    public void LoginExited(ActionEvent e) throws Exception {
        LoginButton.setBackground(Background.fill(Color. rgb(0, 153, 255)));
        LoginButton.setTextFill(Color.WHITE);
    }
}
