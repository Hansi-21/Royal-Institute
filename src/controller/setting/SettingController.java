package controller.setting;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingController {
    public ImageView imgBack;
    public Label lblUsername;
    public Button btnChageNumber;

    public void PasswordChangeOnAction(ActionEvent actionEvent) {

    }

    public void GoBackOnAction(MouseEvent mouseEvent) {
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
}
