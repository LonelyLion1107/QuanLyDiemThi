package oop.project.qldiemthi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    @FXML
    private Pane homePane;

    @FXML
    private TableView<Candidate> candidateTable;

    @FXML
    private TableColumn<Candidate, String> examBlockCol;

    @FXML
    private TableColumn<Candidate, String> dateOfBirthCol;

    @FXML
    private TableColumn<Candidate, String> genderCol;

    @FXML
    private TableColumn<Candidate, String> nameCol;

    @FXML
    private TableColumn<Candidate, String> provinceCol;

    @FXML
    private TableColumn<Candidate, Integer> sbdCol;

    @FXML
    private TableColumn<Candidate, Float> score1Col;

    @FXML
    private TableColumn<Candidate, Float> score2Col;

    @FXML
    private TableColumn<Candidate, Float> score3Col;

    @FXML
    private TableColumn<Candidate, Float> totalScoreCol;

    @FXML
    private TextField nameField;

    @FXML
    private TextField sbdField;

    @FXML
    private ChoiceBox<String> genderChoice;
    private String[] gd = {"Nam", "Nữ"};

    @FXML
    private DatePicker datePicker;

    @FXML
    private ChoiceBox<String> provinceChoice;
    private String[] provinceList = {"Bình Định", "Quảng Ngãi", "Hồ Chí Minh"};

    @FXML
    private ChoiceBox<String> examBlockChoice;
    private String[] blockList = {"A00", "A01", "B00", "C00", "D00"};

    @FXML
    private TextField score1Field;

    @FXML
    private TextField score2Field;

    @FXML
    private TextField score3Field;

    @FXML
    private Button addButton;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    ObservableList<Candidate> initialData() {
        Candidate candidate = new Candidate();
        return FXCollections.observableArrayList(candidate);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderChoice.getItems().addAll(gd);
        examBlockChoice.getItems().addAll(blockList);
        provinceChoice.getItems().addAll(provinceList);

        sbdCol.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("sbd"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("gender"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("dateOfBirth"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("province"));
        examBlockCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("examBlock"));
        score1Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score1"));
        score2Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score2"));
        score3Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score3"));
        totalScoreCol.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("totalScore"));

        candidateTable.setItems(initialData());
        candidateTable.setEditable(true);


    }

    public void addData(MouseEvent e) {
        String name = nameField.getText();
        int sbd = Integer.parseInt(sbdField.getText());
        String gender = genderChoice.getValue();
        String dateOfBirth = datePicker.getValue().format(dateTimeFormatter);
        String province = provinceChoice.getValue();
        String examBlock = examBlockChoice.getValue();
        float score1 = Float.parseFloat(score1Field.getText());
        float score2 = Float.parseFloat(score2Field.getText());
        float score3 = Float.parseFloat(score3Field.getText());

        Candidate newData = new Candidate(name, dateOfBirth, sbd, gender, province);
        newData.setExamBlock(examBlock);
        newData.setScore1(score1);
        newData.setScore2(score2);
        newData.setScore3(score3);
        newData.setTotalScore();
        candidateTable.getItems().add(newData);

        nameField.clear();
        sbdField.clear();
        genderChoice.setValue("");
        datePicker.setValue(null);
        provinceChoice.setValue("");
        examBlockChoice.setValue("");
        score1Field.clear();
        score2Field.clear();
        score3Field.clear();
    }


    public void deleteData(MouseEvent e) {
        TableView.TableViewSelectionModel<Candidate> selectionModel = candidateTable.getSelectionModel();

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] seletedIndices = new Integer[list.size()];
        seletedIndices = list.toArray(seletedIndices);

        Arrays.sort(seletedIndices);
        for (int i = seletedIndices.length - 1; i >= 0; i--) {
            selectionModel.clearSelection(seletedIndices[i].intValue());
            candidateTable.getItems().remove(seletedIndices[i].intValue());
        }
    }

    public void clear(MouseEvent e) {
        candidateTable.getItems().clear();
    }

    public void returnHome(MouseEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
