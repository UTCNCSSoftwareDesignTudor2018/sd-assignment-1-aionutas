package dao;

import connection.ConnectionFactory;
import dao.interfaces.EnrollmentDAOInterface;
import entity.Course;
import entity.Enrollment;
import entity.Student;


import java.sql.*;
import java.util.logging.Level;

public class EnrollmentDAO implements EnrollmentDAOInterface {
    protected static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(EnrollmentDAO.class.getName());
    private String enrollStatement = "INSERT INTO enrollment (enrollmentId, studentId, courseId, period ) VALUES(?,?,?,?)";
    private final static String findEnrollment = "SELECT * FROM enrollment where enrollmentId = ?";
    StudentDAO studentDAO = new StudentDAO();
    CourseDAO courseDAO = new CourseDAO();

    @Override
    public void enroll(Enrollment enrollment) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            statement = con.prepareStatement(enrollStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, enrollment.getEnrollmentId());
            statement.setInt(2, enrollment.getStudent().getId());
            statement.setInt(3, enrollment.getCourse().getCourseId());
            statement.setDouble(4, enrollment.getPeriod());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Could not enroll student");
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(con);
        }


    }


    @Override
    public Enrollment newEnrollment(int enrollmentId, Student student, Course course, int period) {
        return new Enrollment(enrollmentId, student, course, period);
    }

    @Override
    public Enrollment findEnrollmentById(int enrollmentId) {
        Enrollment enrollment = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;

        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findEnrollment);
            findStatement.setLong(1, enrollmentId);
            rs = findStatement.executeQuery();
            rs.next();

            int studentId = Integer.parseInt(rs.getString("studentId"));
            int courseId = rs.getInt("courseId");
            int period = rs.getInt("period");

            enrollment = new Enrollment(enrollmentId, studentDAO.findStudentById(studentId), courseDAO.findById(courseId), period);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EnrollmentDAO:findByEnrollmentId " + e.getMessage());
            return null;
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return enrollment;
    }
}
