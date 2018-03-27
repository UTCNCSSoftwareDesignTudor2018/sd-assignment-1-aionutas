package business;


import business.interfaces.TeacherBLLInterface;
import dao.TeacherDAO;
import dao.interfaces.TeacherDAOInterface;
import entity.Teacher;

public class TeacherBLL implements TeacherBLLInterface {
    TeacherDAOInterface teacherDAO = new TeacherDAO();

    @Override
    public Teacher findTeacherById(int teacherId) {
        Teacher teacher = teacherDAO.findTeacherById(teacherId);
        return teacher;
    }

    @Override
    public void update(int studentId, Teacher teacher)
    {
        teacherDAO.update(studentId, teacher);
    }

    @Override
    public Teacher newTeacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode, String username, String password) {
        return teacherDAO.newTeacher(name, id, address,identityCardNumber, personalNumericalCode, username, password);
    }
}
