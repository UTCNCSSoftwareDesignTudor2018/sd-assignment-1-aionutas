package presentation;

import business.StudentBLL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DeleteStudentController {
        @FXML
        private Label lblTitle;
        @FXML
        private Label lblSuccess;
        @FXML
        private Label lblText1;
        @FXML
        private TextField txtStudentId;
        @FXML
        private Label lblStudentId;

        StudentBLL studentBLL = new StudentBLL();

        @FXML
        public void deleteStudent(ActionEvent actionEvent){
            if(txtStudentId.getText()!=null && !txtStudentId.getText().isEmpty()) {
                int studentId = Integer.parseInt(txtStudentId.getText());
                studentBLL.delete(studentId);
                lblSuccess.setText("Student deleted.");
            }
            else {
                lblSuccess.setText("Could not delete student. Make sure you provided the right id.");
            }
        }

}
