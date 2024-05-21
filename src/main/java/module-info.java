module oop.project.qldiemthi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens oop.project.qldiemthi to javafx.fxml, java.xml.bind;
    exports oop.project.qldiemthi;
}