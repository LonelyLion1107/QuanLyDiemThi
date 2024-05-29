package oop.project.qldiemthi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticController implements Initializable {
    @FXML
    PieChart pieChart;
    @FXML
    LineChart<String, Number> lineChart;
    @FXML
    private Label pieLabel;
    @FXML
    private Label barLabel;
    @FXML
    private Label lineLabel;
    @FXML
    BarChart<String, Number> barChart;
    @FXML
    private Button thongkeButton;
    @FXML
    private Button homeButton;
    @FXML
    private Pane homePane;

    private XYChart.Series<String, Number> lineSeries;
    private XYChart.Series<String, Number> barSeries;

    private CandidateFunction candidateFunction = new CandidateFunction();


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


    public void changeColorOut(MouseEvent e) {
        thongkeButton.setStyle("-fx-background-color:  rgb(255,152,0); -fx-text-fill: white");
    }

    public void changeColorIn(MouseEvent e) {
        thongkeButton.setStyle("-fx-background-color: rgb(255, 173, 51); -fx-text-fill: rgb(153, 92, 0)");
    }

    public void homeOut(MouseEvent e )
    {
        homeButton.setStyle(" -fx-text-fill: white; -fx-background-color: rgb(255,152,0)");
        homePane.setStyle("-fx-background-color:  rgb(255,152,0)");
    }
    public void homeIn(MouseEvent e )
    {
        homeButton.setStyle(" -fx-text-fill: rgb(153, 92, 0); -fx-background-color: white");
        homePane.setStyle("-fx-background-color: rgb(255, 173, 51)");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //LineChart
        double maxA00=0;
        double maxA01=0;
        double maxB00=0;
        double maxC00=0;
        double maxD01=0;


        lineSeries = new XYChart.Series<>();
        for(Candidate e: candidateFunction.getCandidateList())
        {
            if(e.getExamBlock().equals("A00") && maxA00<e.getTotalScore())
                maxA00=e.getTotalScore();
            else if(e.getExamBlock().equals("A01") && maxA01<e.getTotalScore())
                maxA01=e.getTotalScore();
            else if(e.getExamBlock().equals("B00") && maxB00<e.getTotalScore())
                maxB00=e.getTotalScore();
            else if(e.getExamBlock().equals("C00") && maxC00<e.getTotalScore())
                maxC00=e.getTotalScore();
            else if(e.getExamBlock().equals("D01") && maxD01<e.getTotalScore())
                maxD01=e.getTotalScore();
        }
        // reset data
        lineSeries.getData().clear();


        XYChart.Data<String, Number> A00 = new XYChart.Data<>("A00", maxA00);
        XYChart.Data<String, Number> A01 = new XYChart.Data<>("A01", maxA01);
        XYChart.Data<String, Number> B00 = new XYChart.Data<>("B00", maxB00);
        XYChart.Data<String, Number> C00 = new XYChart.Data<>("C00", maxC00);
        XYChart.Data<String, Number> D01 = new XYChart.Data<>("D01", maxD01);

        lineSeries.setName("ĐIỂM TỔNG CAO NHẤT CỦA TỪNG KHỐI");
        lineSeries.getData().addAll(A00,A01,B00,C00,D01);
        lineChart.getData().add(lineSeries);

        // Bar Chart
        double diemTinhA00=0;
        double diemTinhA01=0;
        double diemTinhB00=0;
        double diemTinhC00=0;
        double diemTinhD01=0;
        // tạo mới series
        barSeries = new XYChart.Series<>();
        for(Candidate e: candidateFunction.getCandidateList())
        {
            if(e.getProvince().equals("Bình Phước") && e.getExamBlock().equals("A00") && diemTinhA00<e.getTotalScore())
                diemTinhA00=e.getTotalScore();
            else if(e.getProvince().equals("Bình Phước") && e.getExamBlock().equals("A01") && diemTinhA01<e.getTotalScore())
                diemTinhA01=e.getTotalScore();
            else if(e.getProvince().equals("Bình Phước") && e.getExamBlock().equals("B00") && diemTinhB00<e.getTotalScore())
                diemTinhB00=e.getTotalScore();
            else if(e.getProvince().equals("Bình Phước") && e.getExamBlock().equals("C00") && diemTinhC00<e.getTotalScore())
                diemTinhC00=e.getTotalScore();
            else if(e.getProvince().equals("Bình Phước") && e.getExamBlock().equals("D01") && diemTinhD01<e.getTotalScore())
                diemTinhD01=e.getTotalScore();
        }
        // reset data
        barSeries.getData().clear();

        XYChart.Data<String, Number> diemA00 = new XYChart.Data<>("A00", diemTinhA00);
        XYChart.Data<String, Number> diemA01 = new XYChart.Data<>("A01", diemTinhA01);
        XYChart.Data<String, Number> diemB00 = new XYChart.Data<>("B00", diemTinhB00);
        XYChart.Data<String, Number> diemC00 = new XYChart.Data<>("C00", diemTinhC00);
        XYChart.Data<String, Number> diemD01 = new XYChart.Data<>("D01", diemTinhD01);

        barSeries.setName("SO SÁNH ĐIỂM TỔNG TỪNG KHỐI CỦA TỈNH BÌNH PHƯỚC");
        barSeries.getData().addAll(diemA00,diemA01,diemB00,diemC00,diemD01);
        barChart.getData().add(barSeries);
    }


    // Phương thức reload lại Chart
    public void load(ActionEvent ev) {
        pieChart.setOpacity(1.0f);
        //piechart
        int countA00=0;
        int countA01=0;
        int countB00=0;
        int countC00=0;
        int countD01=0;

        for(Candidate e: candidateFunction.getCandidateList())
        {
            if(e.getExamBlock().equals("A00"))
                countA00++;
            else if(e.getExamBlock().equals("A01"))
                countA01++;
            else if(e.getExamBlock().equals("B00"))
                countB00++;
            else if(e.getExamBlock().equals("C00"))
                countC00++;
            else if(e.getExamBlock().equals("D01"))
                countD01++;
        }
        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("A00", countA00));
        pieChart.getData().add(new PieChart.Data("A01", countA01));
        pieChart.getData().add(new PieChart.Data("B00", countB00));
        pieChart.getData().add(new PieChart.Data("C00", countC00));
        pieChart.getData().add(new PieChart.Data("D01", countD01));

        int sum=countA01+countD01+countA01+countB00+countC00;
        for(PieChart.Data data: pieChart.getData())
        {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
            {
                pieLabel.setText(data.getName()+": " + Math.round((data.getPieValue()/sum*100)*100)/100+"%");
            });
        }

        //LineChart
        lineChart.setOpacity(1.0f);
        // Lưu trữ dữ liệu hiện tại
        XYChart.Series<String, Number> newSeriesLine = new XYChart.Series<>();
        newSeriesLine.setName("ĐIỂM TỔNG CAO NHẤT CỦA TỪNG KHỐI");
        for (XYChart.Data<String, Number> data : lineSeries.getData()) {
            newSeriesLine.getData().add(new XYChart.Data<>(data.getXValue(), data.getYValue()));
        }

        // Xóa dữ liệu hiện tại trong LineChart và thêm lại series mới
        lineChart.getData().clear();
        lineChart.getData().add(newSeriesLine);

        // Gắn lại sự kiện cho các điểm dữ liệu
        for (XYChart.Data<String, Number> data : newSeriesLine.getData()) {
            data.getNode().setOnMouseClicked((MouseEvent event) ->
            {
                lineLabel.setText( "Điểm " +data.getXValue()+ " cao nhất cả nước là : " + data.getYValue());
            });
        }
        // Cập nhật lại series
        lineSeries = newSeriesLine;


        // bar chart
        barChart.setOpacity(1.0f);
        // Lưu trữ dữ liệu hiện tại
        XYChart.Series<String, Number> newSeriesBar = new XYChart.Series<>();
        newSeriesBar.setName("ĐIỂM TỔNG CAO NHẤT CỦA TỪNG KHỐI");
        for (XYChart.Data<String, Number> data : barSeries.getData()) {
            newSeriesBar.getData().add(new XYChart.Data<>(data.getXValue(), data.getYValue()));
        }

        // Xóa dữ liệu hiện tại trong LineChart và thêm lại series mới
        barChart.getData().clear();
        barChart.getData().add(newSeriesBar);

        // Gắn lại sự kiện cho các điểm dữ liệu
        for (XYChart.Data<String, Number> data : newSeriesBar.getData()) {
            data.getNode().setOnMouseClicked((MouseEvent event) ->
            {
                barLabel.setText( "Điểm " +data.getXValue()+ " cao nhất của tỉnh Bình Phước là : " + data.getYValue());
            });
        }
        // Cập nhật lại series
        barSeries = newSeriesBar;
    }


}
