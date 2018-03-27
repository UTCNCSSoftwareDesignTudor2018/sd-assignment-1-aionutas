package dao;

import connection.ConnectionFactory;
import dao.interfaces.TeacherDAOInterface;
import entity.Student;
import entity.Teacher;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDAO implements TeacherDAOInterface {

    protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
    private final static String findTeacher = "SELECT name, address, identityCardNumber, personalNumericalCode FROM teacher where teacherId = ?";
    private final static String updateStatement = "UPDATE teacher SET name=?, identityCardNumber=?, personalNumericalCode=?, address=?, username=?, password=?"
            + " WHERE teacherId=?";

    @Override
    public Teacher findTeacherById(int teacherId) {
        Teacher teacher = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;

        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findTeacher);
            findStatement.setLong(1, teacherId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String address = rs.getString("address");
            int identityCardNumber = rs.getInt("identityCardNumber");
            int personalNumericalCode = rs.getInt("personalNumericalCode");


            teacher = new Teacher(name, teacherId, address, identityCardNumber, personalNumericalCode);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "TeacherDAO:findTeacherById " + e.getMessage());
            return null;
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return teacher;
    }

    @Override
    public void update(int teacherId, Teacher teacher) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement update = null;

        try {

            update = dbConnection.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);

            update.setString(1,teacher.getName());
            update.setInt(2,teacher.getIdentityCardNumber());
            update.setInt(3,teacher.getPersonalNumericalCode());
            update.setString(4,teacher.getAddress());
            update.setString(5,teacher.getUsername());
            update.setString(6,teacher.getPassword());
            update.setInt(7,teacherId);

            update.executeUpdate();

        }
        catch(SQLException e)
        {
            LOGGER.log(Level.WARNING, "StudentDao:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(update);
            ConnectionFactory.close(dbConnection);
        }
    }

    @Override
    public Teacher newTeacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode, String username, String password) {
        return  new Teacher(name,id, address, identityCardNumber,personalNumericalCode, username,  password);
    }
}

