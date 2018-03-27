package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    @FXML
    private Label lblStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void displayUser(String user) {
        lblStatus.setText("Welcome back, " + user +"!");
    }

    @FXML
    public void editAccount(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/presentation/fxml/EditStudentAccount.fxml").openStream());
        primaryStage.setTitle("Edit account");
        primaryStage.setScene(new Scene(root, 605, 462));
        primaryStage.show();
    }

    @FXML
    public void enroll(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/presentation/fxml/EnrollStudent.fxml").openStream());
        primaryStage.setTitle("Enroll Student");
        primaryStage.setScene(new Scene(root, 605, 462));
        primaryStage.show();
    }

    @FXML
    public void seeEnrollment(ActionEvent actionEvent) throws Exception {
        EnrollmentTable tableController = new EnrollmentTable();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Enrollments");
        tableController.startEnrollmentTable(primaryStage);
        primaryStage.show();
    }

}
