package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.transaction.Transaction;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DashboardController {
    public Pane btnManageCourse;
    public Pane btnManageStudent;
    public Label txtStudentCount;
    public AnchorPane root;
    public AreaChart chart;
    public Label txtCourseCount;
    public Pane btnRegistration;
    public Label lblTime;
    public Pane btnSetting;
    public Label lblDate;
    public ImageView imgStudent;
    public ImageView imgSetting;
    public ImageView imgRegistration;
    public ImageView imgCourse;

    public void initialize(){
        setChart();
        setTime();
        setDate();
    }

    public void manageStudetMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/student/manageStudent.fxml"));
        Parent root=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnManageStudent.getScene().getWindow();
        close.close();
    }

    public void manageCourseMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/course/manageCourse.fxml"));
        Parent root=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnManageCourse.getScene().getWindow();
        close.close();
    }

    public void ExitOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING,"Are you sure??", ButtonType.YES,ButtonType.NO);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            System.exit(0);
        }
    }

    public void RegistrationMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/register/Registeration.fxml"));
        Parent root=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnRegistration.getScene().getWindow();
        close.close();
    }

    public void  setChart() {
        XYChart.Series Course1 = new XYChart.Series<>();
        Course1.setName("GDSE");

        Course1.getData().add(new XYChart.Data<>("0", 2));
        Course1.getData().add(new XYChart.Data<>("2", 11));
        Course1.getData().add(new XYChart.Data<>("3", 8));
        Course1.getData().add(new XYChart.Data<>("4", 4));
        Course1.getData().add(new XYChart.Data<>("5", 10));
        Course1.getData().add(new XYChart.Data<>("6", 12));
        Course1.getData().add(new XYChart.Data<>("7", 5));


        XYChart.Series Course2 = new XYChart.Series<>();
        Course2.setName("ABCD");

        Course2.getData().add(new XYChart.Data<>("1", 5));
        Course2.getData().add(new XYChart.Data<>("2", 2));
        Course2.getData().add(new XYChart.Data<>("3", 10));
        Course2.getData().add(new XYChart.Data<>("4", 9));
        Course2.getData().add(new XYChart.Data<>("5", 3));
        Course2.getData().add(new XYChart.Data<>("6", 11));
        Course2.getData().add(new XYChart.Data<>("7", 7));


        XYChart.Series Course3 = new XYChart.Series<>();
        Course3.setName("CMJD");

        Course3.getData().add(new XYChart.Data<>("0", 9));
        Course3.getData().add(new XYChart.Data<>("2", 2));
        Course3.getData().add(new XYChart.Data<>("3", 1));
        Course3.getData().add(new XYChart.Data<>("4", 12));
        Course3.getData().add(new XYChart.Data<>("5", 3));
        Course3.getData().add(new XYChart.Data<>("6", 11));
        Course3.getData().add(new XYChart.Data<>("7", 7));


        XYChart.Series Course4= new XYChart.Series<>();
        Course4.setName("XYZQ");

        Course4.getData().add(new XYChart.Data<>("1", 2));
        Course4.getData().add(new XYChart.Data<>("2", 5));
        Course4.getData().add(new XYChart.Data<>("3", 10));
        Course4.getData().add(new XYChart.Data<>("4", 9));
        Course4.getData().add(new XYChart.Data<>("5", 3));
        Course4.getData().add(new XYChart.Data<>("6", 11));
        Course4.getData().add(new XYChart.Data<>("7", 9));


        chart.getData().addAll(Course1, Course2, Course3,Course4);
    }

    public void setTime(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setDate(){
        LocalDate localDate=LocalDate.now();
        lblDate.setText(localDate.toString());
    }

    public void StudentOnAction(MouseEvent mouseEvent) {



        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/student/manageStudent.fxml"));
        Parent root= null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnManageStudent.getScene().getWindow();
        close.close();
    }

    public void SettingOnAction(MouseEvent mouseEvent) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/setting/setting.fxml"));
        Parent root= null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnSetting.getScene().getWindow();
        close.close();
    }

    public void RegisterOnAction(MouseEvent mouseEvent) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/register/Registeration.fxml"));
        Parent root= null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnRegistration.getScene().getWindow();
        close.close();
    }

    public void CourseOnAction(MouseEvent mouseEvent) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/course/manageCourse.fxml"));
        Parent root= null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) btnManageCourse.getScene().getWindow();
        close.close();
    }


}
