package dao;

import connection.ConnectionFactory;
import dao.interfaces.CourseDAOInterface;
import entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CourseDAO implements CourseDAOInterface {
    private final static String findCourse = "SELECT courseId, course, teacherName, examLevel FROM courses where courseId = ?";

    @Override
    public Course findById(int courseId) {

        Course course = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;

        ResultSet rs = null;

        try {
            findStatement = dbConnection.prepareStatement(findCourse);
            findStatement.setLong(1, courseId);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("course");
            String teacherName = rs.getString("teacherName");
            String examLevel = rs.getString("examLevel");


            course = new Course(courseId, name, teacherName, examLevel);

        } catch (SQLException e) {
            return null;
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return course;

    }
}
