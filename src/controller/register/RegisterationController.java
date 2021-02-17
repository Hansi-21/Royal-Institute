package controller.register;

import business.BOFactory;
import business.BOType;
import business.custom.CourseBO;
import business.custom.RegistrationBO;
import business.custom.StudentBO;
import dto.CourseDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RegisterationController {
    public TextField txtRegID;
    public TextField txtSearch;
    public TextField txtDate;
    public TextField txtFee;
    public ImageView imgBack;
    public ComboBox cmdSID;
    public ComboBox cmdCID;

    RegistrationBO registrationBO= BOFactory.getInstance().getBO(BOType.Registration);
    StudentBO studentBO=BOFactory.getInstance().getBO(BOType.Student);
    CourseBO courseBO=BOFactory.getInstance().getBO(BOType.Course);

    public void initialize(){
        getSID();
        getCID();
       /* genarateRegistrationID();*/
        getDate();

        cmdSID.setFocusTraversable(true);
    }

    public void AddOnAction(ActionEvent actionEvent) {
        try {
            String regId=txtRegID.getText();
            String regFee=txtFee.getText();
            String regDate=txtDate.getText();
            StudentDTO studentDTO = new StudentDTO(cmdSID.getValue().toString());
            CourseDTO courseDTO = new CourseDTO(cmdCID.getValue().toString());

            boolean x = false;
            try {
                x = registrationBO.add(new RegistrationDTO(
                        regId,
                        regFee,
                        regDate,
                        studentDTO,
                        courseDTO
                ));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (x) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student Registerd!", ButtonType.OK).show();
            }
        } finally {

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
                if (registrationBO.delete(txtRegID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "Deleted", ButtonType.OK).show();

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
        Alert alert = new Alert(Alert.AlertType.WARNING,"Are you sure??", ButtonType.YES,ButtonType.NO);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get()==ButtonType.YES){
            System.exit(0);
        }
    }

    public void BackMouseClicked(MouseEvent mouseEvent) {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
        Parent root= null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) imgBack.getScene().getWindow();
        close.close();
    }

    public void getSID(){
        List<StudentDTO> all = null;
        try {
            all = studentBO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (StudentDTO studentDTO:all) {
            cmdSID.getItems().addAll(studentDTO.getStudentID());
        }
    }

    public void getCID(){
        List<CourseDTO> all = null;
        try {
            all = courseBO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (CourseDTO courseDTO:all ) {
            cmdCID.getItems().addAll(courseDTO.getProgramID());
        }
    }

    public void getDate(){
        LocalDate localDate=LocalDate.now();
        txtDate.setText(localDate.toString());
    }

    public void loadAllRegistrations(){
        /*ObservableList<RegistrationDTO> items = tblRegistration.getItems();
        items.clear();
        try {
            List<RegistrationDTO> registrationDTOList = registrationBO.findAll();
            for (RegistrationDTO dto : registrationDTOList) {
                items.add(new RegisterationTM(
                        dto.getRegID()
                        ,dto.getRegDate()
                        ,dto.getRegFee()
                        ,dto.getStudentDTO()
                        ,dto.getCid()
                ));
            }
            tblRegistration.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
