package presentation;

import connection.ConnectionFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblLoginSuccess;


    public boolean isStudent(String user, String password) throws SQLException {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from student where username = ? and password = ?";
        try {
            preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    private boolean isTeacher(String user, String password) throws SQLException {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from teacher where username = ? and password = ?";
        try {
            preparedStatement = dbConnection.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }


    @FXML
    public void log(ActionEvent actionEvent) throws IOException {
        try {
            if (isStudent(txtUserName.getText(),txtPassword.getText() )) {
                lblLoginSuccess.setText("Welcome!");
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("/presentation/fxml/StudentGUI.fxml").openStream());
                primaryStage.setTitle("Student Side");
                primaryStage.setScene(new Scene(root, 605, 414));
                primaryStage.show();
                StudentController studentController = (StudentController) loader.getController();
                studentController.displayUser(txtUserName.getText());
            }
            else if (isTeacher(txtUserName.getText(),txtPassword.getText() )){
                lblLoginSuccess.setText("Welcome!");
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("/presentation/fxml/TeacherGUI.fxml").openStream());
                primaryStage.setTitle("Teacher Side");
                primaryStage.setScene(new Scene(root, 605, 414));
                primaryStage.show();
                TeacherController teacherController = (TeacherController) loader.getController();
                teacherController.displayUser(txtUserName.getText());

            }

            else {
                lblLoginSuccess.setText("Wrong username/password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
