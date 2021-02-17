package controller.course;

import business.BOFactory;
import business.BOType;
import business.custom.CourseBO;
import business.custom.impl.CourseBOImpl;
import dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import view.tm.CourseTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class ManageCourseController {
    public TextField txtID;
    public TextField txtSearch;
    public TextField txtFee;
    public TextField txtDuration;
    public TextField txtName;
    public ImageView imgBack;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TableView tblCourse;

    CourseBOImpl courseBOImpl;

    public void initialize(){

        courseBOImpl= BOFactory.getInstance().getBO(BOType.Course);

        loadAllCourses();

        setCellValueFactory();

        tableListener();

        validation();
    }

    public void EnterOnAction(ActionEvent actionEvent) {
        try {
            CourseDTO courseDTO = courseBOImpl.get(txtSearch.getText());
            if(courseDTO != null){
                txtID.setText(courseDTO.getProgramID());
                txtName.setText(courseDTO.getProgram());
                txtDuration.setText(courseDTO.getDuration());
                txtFee.setText(courseDTO.getFee());

                txtSearch.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddOnAction(ActionEvent actionEvent) {
        String id=txtID.getText();
        String name=txtName.getText();
        String duration=txtDuration.getText();
        String fee=txtFee.getText();

        try {
            if(courseBOImpl.add(new CourseDTO(
                    id,
                    name,
                    duration,
                    fee
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Course Added Successful...").showAndWait();
                txtID.setText(null);
                txtName.setText(null);
                txtDuration.setText(null);
                txtFee.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadAllCourses();

    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        try {
            courseBOImpl.update(new CourseDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtDuration.getText(),
                    txtFee.getText()

            ));
            new Alert(Alert.AlertType.CONFIRMATION,"Course Updated Successful...").showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadAllCourses();
    }

    public void SearchOnAction(ActionEvent actionEvent) {

        try {
            CourseDTO courseDTO = courseBOImpl.get(txtSearch.getText());
            if(courseDTO != null){
                txtID.setText(courseDTO.getProgramID());
                txtName.setText(courseDTO.getProgram());
                txtDuration.setText(courseDTO.getDuration());
                txtFee.setText(courseDTO.getFee());

                txtSearch.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        ButtonType ok = new ButtonType("OK",
                ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("NO",
                ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are You Sure ?", ok, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == ok) {
            try {
                if (courseBOImpl.delete(txtID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "Deleted", ButtonType.OK).show();
                loadAllCourses();
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Alert(Alert.AlertType.WARNING,
                    "Try Again", ButtonType.OK).show();
        } else {

        }
    }

    public void ExitOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING,"Are you sure?", ButtonType.YES,ButtonType.NO);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            System.exit(0);
        }
    }

    public void BackMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
        Parent root=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) imgBack.getScene().getWindow();
        close.close();
    }

    public void loadAllCourses() {
        ObservableList<CourseTM> tmList = FXCollections.observableArrayList();
        List<CourseDTO> all = null;
        try {
            all = courseBOImpl.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(CourseDTO dto : all){
            Button btn = new Button("Delete");
            CourseTM tm = new CourseTM(
                    dto.getProgramID(),
                    dto.getProgram(),
                    dto.getDuration(),
                    dto.getFee(),
                    btn
            );
            tmList.add(tm);
            btn.setOnAction((e) -> {
                try {

                    ButtonType ok = new ButtonType("OK",
                            ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO",
                            ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (courseBOImpl.delete(tm.getProgramID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllCourses();
                            return;
                        }
                        new Alert(Alert.AlertType.WARNING,
                                "Try Again", ButtonType.OK).show();
                    } else {

                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }
        tblCourse.setItems(tmList);
    }

    private void tableListener(){
        tblCourse.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((CourseTM) newValue);
                });
    }

    private void setData(CourseTM tm){
        txtID.setText(tm.getProgramID());
        txtName.setText(tm.getProgram());
        txtDuration.setText(tm.getDuration());
        txtFee.setText(tm.getFee());
    }

    private void setCellValueFactory(){
        colID.setCellValueFactory(new PropertyValueFactory<>("ProgramID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Program"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("Fee"));
    }

    public void validation(){
       /* if(Pattern.compile("^(C)[1-9]{1}$").matcher(txtID.getText()).matches()){ txtName.requestFocus();
            if(Pattern.compile("^[A-z]{1,}$").matcher(txtName.getText()).matches()){ txtName.requestFocus();
                if(Pattern.compile("^[A-z]{1,}$").matcher(txtDuration.getText()).matches()){
                    txtFee.requestFocus();
                    if(Pattern.compile("^[0-9]{1,}$").matcher(txtFee.getText()).matches()){

                    }else{txtFee.setC}
                }else{txtDuration.setFocusColor(Paint.valueOf("red")); txtDuration.requestFocus();}
            } else{txtName.setFocusColor(Paint.valueOf("red")); txtName.requestFocus();}
        }else{txtID.setFocusColor(Paint.valueOf("red"));txtID.requestFocus();}*/
    }
}
