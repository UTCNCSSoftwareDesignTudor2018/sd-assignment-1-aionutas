package presentation;

import business.StudentBLL;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InsertStudentController {
    @FXML
    private Label lblName;
    @FXML
    private Label lblStudentId;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblNPC;
    @FXML
    private Label lblIdentityCardNumber;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblPassword;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtCnp;
    @FXML
    private TextField txtIdentityCardNb;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblSuccess;
    @FXML
    private Button buttonSave;

    StudentBLL studentBLL = new StudentBLL();

    @FXML
    public void createStudentAccount(ActionEvent actionEvent) {



        if(!txtId.getText().isEmpty() && (txtId.getText() != null)
                && txtId.getText()!=null && !txtId.getText().isEmpty()
                && txtAddress.getText()!=null && !txtAddress.getText().isEmpty()
                && txtUserName.getText()!=null && !txtUserName.getText().isEmpty()
                && txtPassword.getText()!=null && !txtPassword.getText().isEmpty()
                && txtCnp.getText()!=null && !txtCnp.getText().isEmpty()
                && txtIdentityCardNb.getText()!=null && !txtIdentityCardNb.getText().isEmpty()
                ) {
            String name = txtName.getText();
            String address = txtAddress.getText();
            int studentId = Integer.parseInt(txtId.getText());
            int cnp = Integer.parseInt(txtCnp.getText());
            int identityCardNb = Integer.parseInt(txtIdentityCardNb.getText());
            String userName = txtUserName.getText();
            String password = txtPassword.getText();

            Student student = studentBLL.newStudent(name, studentId, address, identityCardNb, userName, password, cnp);
            studentBLL.insertStudent(student);
            lblSuccess.setText("All set! :)");
        }

        else {
            lblSuccess.setText("Could not create new account. Make sure id matches/all fields are filled");
        }

    }

}
