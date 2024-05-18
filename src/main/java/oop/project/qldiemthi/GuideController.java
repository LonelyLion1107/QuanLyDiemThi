package oop.project.qldiemthi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class GuideController implements Initializable {
    @FXML
    private TextArea guideContent;

    private String content = "Hướng dẫn nhập điểm:";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guideContent.setText(content);
    }
}
