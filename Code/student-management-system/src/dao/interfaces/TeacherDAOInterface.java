package dao.interfaces;



import entity.Teacher;

public interface TeacherDAOInterface {
    public Teacher findTeacherById(int teacherId);
    public void update(int teacherId, Teacher teacher);
    public Teacher newTeacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode, String username, String password);
}
