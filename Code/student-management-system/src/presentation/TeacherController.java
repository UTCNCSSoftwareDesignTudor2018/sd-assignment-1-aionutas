package presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherController {
    @FXML
    private Label lblStatus;


    public void displayUser(String user) {
        lblStatus.setText("Welcome back, " + user +"!");
    }

    @FXML
    public void editAccount(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/presentation/fxml/EditTeacherAccount.fxml").openStream());
        primaryStage.setTitle("Edit profile info");
        primaryStage.setScene(new Scene(root, 605, 462));
        primaryStage.show();
    }

    @FXML
    public void createAccount(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/presentation/fxml/InsertStudent.fxml").openStream());
        primaryStage.setTitle("Create new student account");
        primaryStage.setScene(new Scene(root, 605, 462));
        primaryStage.show();
    }
    @FXML
    public void seeStudentList(ActionEvent actionEvent) throws Exception {
        TableController tableController = new TableController();
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Students Table");
        tableController.start(primaryStage);
        primaryStage.show();
    }


    @FXML
    public void deleteStudent(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("/presentation/fxml/DeleteStudent.fxml").openStream());
        primaryStage.setTitle("Delete Student");
        primaryStage.setScene(new Scene(root, 605, 462));
        primaryStage.show();
    }
}
