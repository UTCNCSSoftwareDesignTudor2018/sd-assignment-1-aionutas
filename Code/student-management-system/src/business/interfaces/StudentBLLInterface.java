package business.interfaces;

import entity.Student;

import java.util.List;

public interface StudentBLLInterface {
    public Student findStudentById(int studentId);
    public void update(int studentId, Student student);
    public List<Student> findAll();
    public void delete (int studentId);
    public void insertStudent(Student student);
    public Student newStudent(String name, int id, String address, int identityCardNumber, String username, String password, int personalNumericalCode);
}
