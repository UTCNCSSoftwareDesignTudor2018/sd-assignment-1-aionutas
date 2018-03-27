package business.interfaces;


import entity.Teacher;

public interface TeacherBLLInterface {
    public Teacher findTeacherById(int teacherId);
    public void update(int studentId, Teacher teacher);
    public Teacher newTeacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode, String username, String password);
}
