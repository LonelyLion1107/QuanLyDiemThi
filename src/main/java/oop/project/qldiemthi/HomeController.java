package oop.project.qldiemthi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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

    public void editIn(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.WHITE);
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        editPane.setEffect(dropShadow);
        editLabel.setStyle("-fx-text-fill: #36b0fc");
    }

    public void editOut(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        dropShadow.setColor(Color.color(0.017999999225139618,0.8999999761581421,0.7509852647781372));
        editPane.setEffect(dropShadow);
        editLabel.setStyle("-fx-text-fill: #2aacfc");
    }

    public void statisticIn(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.WHITE);
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        statisticPane.setEffect(dropShadow);
        statisticLabel.setStyle("-fx-text-fill: #36b0fc");
    }

    public void statisticOut(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        dropShadow.setColor(Color.color(0.017999999225139618,0.8999999761581421,0.7509852647781372));
        statisticPane.setEffect(dropShadow);
        statisticLabel.setStyle("-fx-text-fill: #2aacfc");
    }

    public void logOutIn(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.WHITE);
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        logoutPane.setEffect(dropShadow);
        logoutLabel.setStyle("-fx-text-fill: white");
    }



    public void logOutOut(MouseEvent event) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setHeight(35);
        dropShadow.setRadius(16);
        dropShadow.setWidth(32);
        dropShadow.setColor(Color.color(0.017999999225139618,0.8999999761581421,0.7509852647781372));
        logoutPane.setEffect(dropShadow);
        logoutLabel.setStyle("-fx-text-fill: white");
    }


    public void showEdit(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
            stage = new Stage();
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
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
            stage.setResizable(false);
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
            stage.setResizable(false);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

