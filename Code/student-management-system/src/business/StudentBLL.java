package business;

import business.interfaces.StudentBLLInterface;
import dao.StudentDAO;
import dao.interfaces.StudentDAOInterface;
import entity.Student;

import java.util.List;

public class StudentBLL implements StudentBLLInterface {

    StudentDAOInterface studentDao = new StudentDAO();

    @Override
    public Student findStudentById(int studentId) {
        Student student = studentDao.findStudentById(studentId);
        return student;
    }

    @Override
    public void update(int studentId, Student student) {
        studentDao.update(studentId, student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(int studentId) {
        studentDao.delete(studentId);
    }

    @Override
    public void insertStudent(Student student) {
         studentDao.insertStudent(student);
    }

    @Override
    public Student newStudent(String name, int id, String address, int identityCardNumber, String username, String password, int personalNumericalCode) {
        return studentDao.newStudent(name, id, address, identityCardNumber,  username, password,  personalNumericalCode);
    }

}
