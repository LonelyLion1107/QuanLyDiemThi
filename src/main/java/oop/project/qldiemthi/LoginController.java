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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    Button LoginButton;
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    private Parent root;
    private Scene scene;


    @FXML
    public void Login(ActionEvent e) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = new User(username, password);


        if("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            root = loader.load();

            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
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
    public void LoginEntered(MouseEvent e) throws Exception {
        LoginButton.setBackground(Background.fill(Color.WHITE));
        LoginButton.setTextFill(Color. rgb(0, 153, 255));
        LoginButton.setBorder(Border.stroke(Color.AQUAMARINE));

    }

    @FXML
    public void LoginExited(MouseEvent e) throws Exception {
        LoginButton.setBackground(Background.fill(Color. rgb(0, 153, 255)));
        LoginButton.setTextFill(Color.WHITE);
    }
}
