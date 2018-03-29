package presentation;

import business.StudentBLL;
import entity.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/presentation/fxml/Login.fxml"));
        primaryStage.setTitle("StudApp");
        primaryStage.setScene(new Scene(root, 605, 420));
        primaryStage.show();
        StudentBLL studentBLL = new StudentBLL();
        List<Student> students = studentBLL.findAll();
        System.out.println(students.get(0));
        System.out.println(students.get(1));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
