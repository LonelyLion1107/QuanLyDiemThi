package oop.project.qldiemthi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoginButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event ->
        {
            LoginButton.setStyle("-fx-background-color: rgb(102, 194, 255); -fx-text-fill: rgb(0, 153, 255); -fx-border-color: white;");
        });

        LoginButton.addEventHandler(MouseEvent.MOUSE_EXITED, event ->
        {
            LoginButton.setStyle("-fx-background-color: rgb(0, 153, 255); -fx-text-fill: white; -fx-border-color: white");
        });
    }
}
