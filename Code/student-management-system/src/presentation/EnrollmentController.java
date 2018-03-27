package presentation;

import business.CourseBLL;
import business.EnrollmentBLL;
import business.StudentBLL;
import entity.Enrollment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnrollmentController {
    @FXML
    private Label lblStudentId1;
    @FXML
    private Label lblStudentId;
    @FXML
    private Label lblStudentId2;
    @FXML
    private Label lblStudentId3;


    @FXML
    private TextField txtEnrollment;
    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtCourseId;
    @FXML
    private TextField txtPeriod;

    @FXML
    private Label lblSuccess;

    EnrollmentBLL enrollmentBLL = new EnrollmentBLL();
    StudentBLL studentBLL = new StudentBLL();
    CourseBLL courseBLL = new CourseBLL();

    @FXML
    public void enroll(ActionEvent actionEvent) {


        if (!txtEnrollment.getText().isEmpty() && (txtEnrollment.getText() != null)
                && txtStudentId.getText() != null && !txtStudentId.getText().isEmpty()
                && txtCourseId.getText() != null && !txtCourseId.getText().isEmpty()
                && txtPeriod.getText() != null && !txtPeriod.getText().isEmpty()
                ) {

            int enrollmentId = Integer.parseInt(txtEnrollment.getText());
            int studentId = Integer.parseInt(txtStudentId.getText());
            int courseId = Integer.parseInt(txtCourseId.getText());
            int period = Integer.parseInt(txtPeriod.getText());

            Enrollment enrollment = enrollmentBLL.newEnrollment(enrollmentId, studentBLL.findStudentById(studentId), courseBLL.findById(courseId), period);
            enrollmentBLL.enroll(enrollment);
            lblSuccess.setText("All set! :)");
        } else {
            lblSuccess.setText("Could not enroll. Make sure id matches/all fields are filled");
        }

    }


}
