package oop.project.qldiemthi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class EditController implements Initializable {

    //Home Pane
    @FXML
    private Pane homePane;

    @FXML
    private TextField searchInput;

    //Candidate Table
    @FXML
    private TableView<Candidate> candidateTable;

    //Candidate Table Items
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
    private ComboBox<String> genderChoice;
    private final String[] genderList = {"Nam", "Nữ"};

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> provinceChoice;
    private final String[] provinceList = {"An Giang", "Bà Rịa - Vũng Tàu", "Bạc Liêu", "Bắc Kạn", "Bắc Giang", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "TP. Cần Thơ", "TP. Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "TP. Hà Nội", "Hà Tĩnh", "Hải Dương", "TP. Hải Phòng", "Hòa Bình", "TP. Hồ Chí Minh", "Hậu Giang", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lào Cai", "Lạng Sơn", "Lâm Đồng", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};

    @FXML
    private ComboBox<String> examBlockChoice;
    private final String[] examBlockList = {
            "A00 (Toán, Lý, Hóa)",
            "A01 (Toán, Lý, Anh)",
            "B00 (Toán, Hóa, Sinh)",
            "C00 (Văn, Sử, Địa)",
            "D01 (Toán, Văn, Anh)"
    };

    @FXML
    private TextField score1Field;

    @FXML
    private TextField score2Field;

    @FXML
    private TextField score3Field;

    //Date Format
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private CandidateXML candidateXML = new CandidateXML();

    private ObservableList<Candidate> candidateData = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderChoice.getItems().addAll(genderList);
        examBlockChoice.getItems().addAll(examBlockList);
        provinceChoice.getItems().addAll(provinceList);

        nameCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("name"));
        sbdCol.setCellValueFactory(new PropertyValueFactory<Candidate, Integer>("sbd"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("gender"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("dateOfBirth"));
        provinceCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("province"));
        examBlockCol.setCellValueFactory(new PropertyValueFactory<Candidate, String>("examBlock"));
        score1Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score1"));
        score2Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score2"));
        score3Col.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("score3"));
        totalScoreCol.setCellValueFactory(new PropertyValueFactory<Candidate, Float>("totalScore"));

        candidateTable.setItems(candidateData);
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

        Candidate candidate = new Candidate(name, dateOfBirth, sbd, gender, province, examBlock, score1, score2, score3);

        candidateData.add(candidate);
        candidateList.add(candidate);

        clearInput();
    }

    public void getInfo(MouseEvent e) {
        Candidate data = candidateTable.getSelectionModel().getSelectedItem();

        if(data != null) {
            nameField.setText(data.getName());
            sbdField.setText(String.valueOf(data.getSbd()));
            genderChoice.setValue(data.getGender());
            datePicker.setValue(LocalDate.parse(data.getDateOfBirth(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            provinceChoice.setValue(data.getProvince());
            examBlockChoice.setValue(data.getExamBlock());
            score1Field.setText(String.valueOf(data.getScore1()));
            score2Field.setText(String.valueOf(data.getScore2()));
            score3Field.setText(String.valueOf(data.getScore3()));
        }
    }

    public void updateData(MouseEvent e) {
        int row = candidateTable.getSelectionModel().getSelectedIndex();

        String name = nameField.getText();
        int sbd = Integer.parseInt(sbdField.getText());
        String gender = genderChoice.getValue();
        String dateOfBirth = datePicker.getValue().format(dateTimeFormatter);
        String province = provinceChoice.getValue();
        String examBlock = examBlockChoice.getValue();
        float score1 = Float.parseFloat(score1Field.getText());
        float score2 = Float.parseFloat(score2Field.getText());
        float score3 = Float.parseFloat(score3Field.getText());

        Candidate newData = new Candidate(name, dateOfBirth, sbd, gender, province, examBlock, score1, score2, score3);

        Candidate oldData = candidateData.get(row);
        candidateData.set(row, newData);
        candidateList.set(row, newData);

        clearInput();
    }

    public void deleteData(MouseEvent e) {
        int row = candidateTable.getSelectionModel().getSelectedIndex();

        if(row >= 0) {
            candidateData.remove(row);
            candidateList.remove(row);
        }
    }

    public void clearTableView(MouseEvent e) {
        candidateTable.getItems().clear();
        candidateData.clear();
        clearInput();
    }


    public void clearInput() {
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

    public void search() {
        String searchContent = searchInput.getText();
        
    }

    public void guide(MouseEvent e){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Guide.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
