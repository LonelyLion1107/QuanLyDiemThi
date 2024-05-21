package oop.project.qldiemthi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticController implements Initializable {
    @FXML
    PieChart pieChart;
    @FXML
    LineChart<String, Number> lineChart;

    EditController editController;


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editController = new EditController();
        // PieChart
        int countA00=0;
        int countA01=0;
        int countB00=0;
        int countC00=0;
        int countD01=0;

        for(Candidate e: editController.candidateData)
        {
            if(e.getExamBlock()=="A00")
                countA00++;
            else if(e.getExamBlock()=="A01")
                countA01++;
            else if(e.getExamBlock()=="B00")
                countB00++;
            else if(e.getExamBlock()=="C00")
                countC00++;
            else if(e.getExamBlock()=="D00")
                countD01++;
            else if(e.getExamBlock()=="D01")
                countD01++;
        }
        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("A00", countA00));
        pieChart.getData().add(new PieChart.Data("A01", countA01));
        pieChart.getData().add(new PieChart.Data("B00", countB00));
        pieChart.getData().add(new PieChart.Data("C00", countC00));
        pieChart.getData().add(new PieChart.Data("D01", countD01));

        for(PieChart.Data data: pieChart.getData())
        {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(data.getName());
                alert.setContentText(data.getName()+" "+data.getPieValue());
                alert.showAndWait();
            });
        }

        //LineChart
        double maxA00=0;
        double maxA01=0;
        double maxB00=0;
        double maxC00=0;
        double maxD01=0;
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for(Candidate e: editController.candidateData)
        {
            if(e.getExamBlock()=="A00" && maxA00<e.getTotalScore())
                maxA00=e.getTotalScore();
            else if(e.getExamBlock()=="A01" && maxA01<e.getTotalScore())
                maxA01=e.getTotalScore();
            else if(e.getExamBlock()=="B00" && maxB00<e.getTotalScore())
                maxB00=e.getTotalScore();
            else if(e.getExamBlock()=="C00" && maxC00<e.getTotalScore())
                maxC00=e.getTotalScore();
            else if(e.getExamBlock()=="D01" && maxD01<e.getTotalScore())
                maxD01=e.getTotalScore();
        }
        XYChart.Data<String, Number> A00 = new XYChart.Data<>("A00", maxA00);
        XYChart.Data<String, Number> A01 = new XYChart.Data<>("A01", maxA01);
        XYChart.Data<String, Number> B00 = new XYChart.Data<>("B00", maxB00);
        XYChart.Data<String, Number> C00 = new XYChart.Data<>("C00", maxC00);
        XYChart.Data<String, Number> D01 = new XYChart.Data<>("D01", maxD01);

        series.setName("ĐIỂM TRUNG BÌNH CAO NHẤT CỦA TỪNG KHỐI");
        series.getData().add(A00);
        lineChart.getData().addAll(series);
    }


}
