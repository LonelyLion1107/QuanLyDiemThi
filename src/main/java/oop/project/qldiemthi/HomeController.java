package oop.project.qldiemthi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HomeController {
    @FXML
    private AnchorPane Home;
    @FXML
    private Pane editPane;
    @FXML
    private Pane logoutPane;
    @FXML
    private Pane statisticPane;
    @FXML
    private Label logoutLabel;
    @FXML
    private Label editLabel;
    @FXML
    private Label statisticLabel;

    private Stage stage;


    public void showEdit(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
            stage = new Stage();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showStatistic(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Statistic.fxml"));
            stage = new Stage();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void logout(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage = new Stage();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

