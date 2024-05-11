package oop.project.qldiemthi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oop.project.qldiemthi.entity.Candidate;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    @FXML
    private Pane homePane;

    @FXML
    private TableColumn<Candidate, String> blockExamCol;

    @FXML
    private TableView<Candidate> candidateTable;

    @FXML
    private TableColumn<Candidate, LocalDate> dateOfBirthCol;

    @FXML
    private TableColumn<Candidate, String> genderCol;

    @FXML
    private TableColumn<Candidate, String> nameCol;

    @FXML
    private TableColumn<Candidate, String> provinceCol;

    @FXML
    private TableColumn<Candidate, Integer> sbdCol;

    @FXML
    private TableColumn<Candidate, ?> scoreCol;

    @FXML
    private TableColumn<Candidate, Float> subject1Col;

    @FXML
    private TableColumn<Candidate, Float> subject2Col;

    @FXML
    private TableColumn<Candidate, Float> subject3Col;

    @FXML
    private TableColumn<Candidate, Float> totalScoreCol;

//    ObservableList<Candidate> initialData() {
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void returnHome(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
