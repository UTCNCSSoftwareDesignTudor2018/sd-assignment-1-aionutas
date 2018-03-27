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
}
