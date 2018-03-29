package dao;

import connection.ConnectionFactory;
import dao.interfaces.StudentDAOInterface;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

public class StudentDAO implements StudentDAOInterface {

    protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
    private final static String findStudent = "SELECT name, address, identityCardNumber, personalNumericalCode FROM student where studentId = ?";
    private final static String updateStatement = "UPDATE student SET name=?, identityCardNumber=?, personalNumericalCode=?, address=?, username=?, password=?"
            + " WHERE studentId=?";
    private final String findAllStatementString = "SELECT * FROM student";
    private final String deleteStudent = "DELETE FROM student WHERE studentId = ?";

        @Override
        public Student findStudentById(int studentId) {
            Student student = null;

            Connection dbConnection = ConnectionFactory.getConnection();
            PreparedStatement findStatement = null;

            ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findStudent);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String address = rs.getString("address");
            int identityCardNumber = rs.getInt("identityCardNumber");
            int personalNumericalCode = rs.getInt("personalNumericalCode");


            student = new Student(name, studentId, address, identityCardNumber, personalNumericalCode);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "StudentDAO:findByStudentId " + e.getMessage());
            return null;
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return student;
    }


    public void update(int studentId, Student student) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement update = null;

        try {

            update = dbConnection.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);

            update.setString(1,student.getName());
            update.setInt(2,student.getIdentityCardNumber());
            update.setInt(3,student.getPersonalNumericalCode());
            update.setString(4,student.getAddress());
            update.setString(5,student.getUsername());
            update.setString(6,student.getPassword());
            update.setInt(7,studentId);

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

    public List<Student> findAll()
    {
        List<Student> allStudents = new ArrayList<>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findAllStatement = null;
        ResultSet rs = null;

        try {
            findAllStatement = dbConnection.prepareStatement(findAllStatementString);
            rs = findAllStatement.executeQuery();

            while(rs.next())
            {
                int studentId = rs.getInt("studentId");
                String name = rs.getString("name");
                int identityCardNumber = Integer.parseInt(rs.getString("identityCardNumber"));
                int personalNumericalCode = Integer.parseInt(rs.getString("personalNumericalCode"));
                String address = rs.getString("address");
                String username = rs.getString("username");
                String password = rs.getString("password");


                Student student = new Student(name, studentId, address, identityCardNumber, username, password, personalNumericalCode);
                allStudents.add(student);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"StudentDao:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findAllStatement);
            ConnectionFactory.close(dbConnection);
        }

        return allStudents;
    }


    @Override
    public void delete(int studentId) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement(deleteStudent);
            statement.setInt(1, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "StudentDao:deleteStudent " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(conn);
        }
    }

    @Override
    public void insertStudent(Student student) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int insertedId = 0;

        try {
            statement = con.prepareStatement("INSERT INTO student (studentId, name, address, personalNumericalCode, identityCardNumber, username, password) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getAddress());
            statement.setInt(4, student.getPersonalNumericalCode());
            statement.setInt(5, student.getIdentityCardNumber());
            statement.setString(6, student.getUsername());
            statement.setString(7, student.getPassword());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                insertedId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"StudentDao:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }

    }

    @Override
    public Student newStudent(String name, int id, String address, int identityCardNumber, String username, String password, int personalNumericalCode) {
        return new Student(name, id, address, identityCardNumber,  username, password,  personalNumericalCode);
    }


}
