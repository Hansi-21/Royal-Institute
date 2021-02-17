package controller.student;

import business.BOFactory;
import business.BOType;
import business.custom.impl.StudentBOImpl;
import dto.StudentDTO;
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
import javafx.stage.Stage;
import view.tm.StudentTM;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ManageStudentController {
    public TextField txtID;
    public TextField txtSearch;
    public TextField txtAge;
    public TextField txtAddress;
    public TextField txtName;
    public ImageView imgBack;
    public TableView tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colAge;

    StudentBOImpl studentBOImpl;

    public void initialize(){
        studentBOImpl=BOFactory.getInstance().getBO(BOType.Student);
        try {
            genarateStudentID();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableListener();

        setCellValueFactory();

        loadAllStudents();
    }

    public void genarateStudentID() throws Exception {

    }

    public void EnterOnAction(ActionEvent actionEvent) {
    }

    public void AddOnAction(ActionEvent actionEvent) {
        String id=txtID.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String age=txtAge.getText();

        try {
            if(studentBOImpl.add(new StudentDTO(
                    id,
                    name,
                    address,
                    age
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Added Successful...").showAndWait();
                txtID.setText(null);
                txtName.setText(null);
                txtAddress.setText(null);
                txtAge.setText(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadAllStudents();
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        try {
            studentBOImpl.update(new StudentDTO(
                    txtID.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtAge.getText()
            ));
            new Alert(Alert.AlertType.CONFIRMATION,"Student Updated Successful...").showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loadAllStudents();
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtAge.clear();

    }

    public void SearchOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO= null;
        try {
            studentDTO = studentBOImpl.get(txtSearch.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(studentDTO != null){
            txtID.setText(studentDTO.getStudentID());
            txtName.setText(studentDTO.getName());
            txtAddress.setText(studentDTO.getAddress());
            txtAge.setText(studentDTO.getAge());

            txtSearch.clear();
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
                if (studentBOImpl.delete(txtID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "Deleted", ButtonType.OK).show();
                loadAllStudents();
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

    public void BackMouseClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/view/dashboard.fxml"));
        Parent root=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        Stage close= (Stage) imgBack.getScene().getWindow();
        close.close();
    }

    public void loadAllStudents(){
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> all = null;
        try {
            all = studentBOImpl.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(StudentDTO dto : all){
            Button btn = new Button("Delete");
            StudentTM tm = new StudentTM(
                    dto.getStudentID(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getAge(),
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
                        if (studentBOImpl.delete(tm.getStudentID())) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "Deleted", ButtonType.OK).show();
                            loadAllStudents();
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
        tblStudent.setItems(tmList);
    }

    private void tableListener(){
        tblStudent.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    setData((StudentTM) newValue);
                });
    }

    private void setData(StudentTM tm){
        txtID.setText(tm.getStudentID());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtAge.setText(tm.getAge());
    }

    private void setCellValueFactory(){
        colID.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
    }


}
