package presentation;

import business.StudentBLL;
import entity.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class EditStudentAccountController {
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
    public void editStudentAccount(ActionEvent actionEvent) {



       if(!txtId.getText().isEmpty() && (txtId.getText() != null) && studentBLL.findStudentById(Integer.parseInt(txtId.getText()))!= null
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

           Student initialStudent = studentBLL.findStudentById(Integer.parseInt(txtId.getText()));
           Student updatedStudent = studentBLL.newStudent(name, studentId, address, identityCardNb, userName, password, cnp);
           studentBLL.update(initialStudent.getId(), updatedStudent);
           lblSuccess.setText("All set! :)");
       }

       else {
           lblSuccess.setText("Could not update. Make sure id matches/all fields are filled");
       }

    }



}
