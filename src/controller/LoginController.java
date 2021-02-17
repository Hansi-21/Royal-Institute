package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField txtUsername;
    public TextField txtPassword;
    public Button BtnLogin;
    public AnchorPane root;
    public ImageView ClickedEye;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String username=txtUsername.getText();
        String password= txtPassword.getText();
        if(username.length()>0 && password.length()>0) {
            if (username.equalsIgnoreCase("hansi") && password.equalsIgnoreCase("1121")) {
               FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../view/dashboard.fxml"));
               Parent root=(Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                Stage close= (Stage) BtnLogin.getScene().getWindow();
                close.close();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Invalid UserName or Password", ButtonType.OK).show();
            }
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Please fill required fields", ButtonType.OK).show();
        }
    }


    public void EyeMouseClicked(MouseEvent mouseEvent) {

    }
}
