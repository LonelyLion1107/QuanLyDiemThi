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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class EditController implements Initializable {

    //Home Pane
    @FXML
    private Pane homePane;

    @FXML
    private TextField searchInput;

    @FXML
    private ComboBox<String> searchChoice;
    private String[] searchList = {"Theo tên", "Theo SBD"};

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

    private CandidateFunction candidateFunction = new CandidateFunction();

    private List<Candidate> candidateList = candidateFunction.getCandidateList();

    private ObservableList<Candidate> candidateData = FXCollections.observableArrayList(candidateList);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchChoice.getItems().addAll(searchList);
        genderChoice.getItems().addAll(genderList);
        examBlockChoice.getItems().addAll(examBlockList);
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

        candidateTable.getSortOrder().add(sbdCol);
        sbdCol.setSortType(TableColumn.SortType.ASCENDING);

        candidateTable.setItems(candidateData);
    }

    public void addData(MouseEvent e) {
        try {
            String name = nameField.getText();
            int sbd = Integer.parseInt(sbdField.getText());
            String gender = genderChoice.getValue();
            String dateOfBirth = datePicker.getValue().format(dateTimeFormatter);
            String province = provinceChoice.getValue();
            String examBlock = examBlockChoice.getValue().substring(0, 3);
            float score1 = Float.parseFloat(score1Field.getText());
            float score2 = Float.parseFloat(score2Field.getText());
            float score3 = Float.parseFloat(score3Field.getText());

            Candidate candidate = new Candidate(name, dateOfBirth, sbd, gender, province, examBlock, score1, score2, score3);

            if (checkInput()) {
                candidateFunction.addCandidate(candidate);
                candidateData.add(candidate);
                candidateTable.refresh();
                clearInput();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Something you have inputted is wrong");
                alert.setContentText("Please read the guide and check information fields carefully");
                alert.showAndWait();
            }
        } catch (Exception exception) {
            exception.getMessage();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Something you have inputted is wrong");
            alert.setContentText("Please read the guide and check information fields carefully");
            alert.showAndWait();
        }
    }

    public void getInfo(MouseEvent e) {
        Candidate data = candidateTable.getSelectionModel().getSelectedItem();

        if (data != null) {
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

        try {
            String name = nameField.getText();
            int sbd = Integer.parseInt(sbdField.getText());
            String gender = genderChoice.getValue();
            String dateOfBirth = datePicker.getValue().format(dateTimeFormatter);
            String province = provinceChoice.getValue();
            String examBlock = examBlockChoice.getValue().substring(0, 3);
            float score1 = Float.parseFloat(score1Field.getText());
            float score2 = Float.parseFloat(score2Field.getText());
            float score3 = Float.parseFloat(score3Field.getText());

            Candidate candidate = new Candidate(name, dateOfBirth, sbd, gender, province, examBlock, score1, score2, score3);
            if (checkInput()) {
                candidateData.set(row, candidate);
                candidateFunction.editCandidate(candidate, row);
                candidateTable.refresh();
                clearInput();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Something you have inputted is wrong");
                alert.setContentText("Please read the guide and check information fields carefully");
                alert.showAndWait();
            }
        } catch (Exception exception) {
            exception.getMessage();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Something you have inputted is wrong");
            alert.setContentText("Please read the guide and check information fields carefully");
            alert.showAndWait();
        }
    }

    public void deleteData(MouseEvent e) {
        int row = candidateTable.getSelectionModel().getSelectedIndex();

        if (row >= 0) {
            candidateData.remove(row);
            candidateFunction.deleteCandidate(row);
        }
        clearInput();
    }

    public void clearTableView(MouseEvent e) {
        candidateTable.getItems().clear();
        candidateData.clear();
        candidateFunction.clearAll();
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

    public void search(MouseEvent e) {
        String searchContent = searchInput.getText();
        String searchType = searchChoice.getValue();
        List<Candidate> searchList = new ArrayList<Candidate>();

        if (searchType == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search Error");
            alert.setHeaderText("Search choice is null");
            alert.setContentText("Please choose type of searching");
            alert.showAndWait();
            return;
        } else if (searchType.equals("Theo tên")) {
            if (searchContent.matches(".*[a-zA-Z].*")) {
                for (Candidate item : candidateList) {
                    String name = item.getName();
                    if (name.contains(searchContent)) {
                        searchList.add(item);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Error");
                alert.setHeaderText("Something you have inputted is wrong");
                alert.setContentText("Please only input character");
                alert.showAndWait();
                return;
            }
        } else if (searchType.equals("Theo SBD")) {
            try {
                int sbd = Integer.parseInt(searchContent);
                for (Candidate item : candidateList) {
                    if (item.getSbd() == sbd) {
                        searchList.add(item);
                    }
                }
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Search Error");
                alert.setHeaderText("Something you have inputted is wrong");
                alert.setContentText("Please only input number");
                alert.showAndWait();
                return;
            }
        }

        if(searchList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search result");
            alert.setHeaderText("No candidate is found");
            alert.setContentText("We can't find any candidate satisfy with your request");
            alert.showAndWait();
        } else {
            candidateData.clear();
            candidateData.addAll(searchList);
        }
    }

    public void searchExit(MouseEvent e) {
        searchChoice.setValue("Theo tên");
        searchInput.setText(null);
        candidateData.clear();
        candidateData.addAll(candidateList);
        candidateTable.refresh();
    }

    public boolean checkInput() {
        boolean check = true;
        String name = nameField.getText();
        int sbd = Integer.parseInt(sbdField.getText());
        String gender = genderChoice.getValue();
        String dateOfBirth = datePicker.getValue().format(dateTimeFormatter);
        String province = provinceChoice.getValue();
        String examBlock = examBlockChoice.getValue().substring(0, 3);
        float score1 = Float.parseFloat(score1Field.getText());
        float score2 = Float.parseFloat(score2Field.getText());
        float score3 = Float.parseFloat(score3Field.getText());
        if (name == "") {
            check = false;
        }

        for (int i = 0; i < candidateList.size(); i++) {
            if (candidateList.get(i).getSbd() == sbd) {
                check = false;
            }
            break;
        }

        if (gender == null) {
            check = false;
        }


        if (province == null) {
            check = false;
        }

        if (score1 < 0 || score1 > 10) {
            check = false;
        }

        if (score2 < 0 || score2 > 10) {
            check = false;
        }

        if (score3 < 0 || score3 > 10) {
            check = false;
        }

        return check;
    }

    public void guide(MouseEvent e) {
        try {
            Stage stage = new Stage();
            BorderPane guidePane = FXMLLoader.load(getClass().getResource("Guide.fxml"));

            Text text = new Text();
            text.setFont(new Font("Arial", 14));
            text.setWrappingWidth(500);
            text.setLineSpacing(1.3);
            text.setText(" Hướng dẫn thông tin thí sinh: \n " +
                            "- Tên chỉ được bao gồm các ký tự và dấu\n " +
                            "- SBD là các số và không chứa dữ liệu dạng khác\n " +
                            "- Nhập điểm theo thứ tự các môn của khối mình chọn\n " +
                            "VD: Nếu chọn khối A00 thì môn 1 sẽ là Toán, môn 2 là Lý, môn 3 là Hóa \n" +
                            "- Thứ tự các môn của khối được mô tả trong ô khối thi khi ta ghi mới hoặc sửa đổi thông tin của thí sinh \n" +
                            "- Điểm phải nằm trong khoảng từ 0 đến 10, nếu vô tình nhập ngoài khoảng này chương trình sẽ báo lỗi \n" + "\n" +
                            "Hướng dẫn tìm kiếm: \n" +
                            "- Trước tiên ta cần phải chọn đối tượng muốn tìm kiếm ở ô Select Type \n" +
                            "- Sau đó nhập đúng thông tin ta muốn tìm kiếm vào ô tìm kiếm. \n" +
                            "Lưu ý rằng khi tìm SBD thì ta phải nhập vào số, tìm tên thì ta cần nhập vào các ký tự \n" +
                            "- Để thoát khỏi chế độ tìm kiếm, ta nhấn vào nút Exit Search");

            guidePane.setCenter(text);

            Scene scene = new Scene(guidePane);
            stage.setScene(scene);
            stage.setTitle("Guide");
            stage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
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
