package business;

import business.interfaces.EnrollmentBLLInterface;
import dao.EnrollmentDAO;
import entity.Course;
import entity.Enrollment;
import entity.Student;

public class EnrollmentBLL implements EnrollmentBLLInterface {
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    @Override
    public void enroll(Enrollment enrollment) {
        enrollmentDAO.enroll(enrollment);
    }

    @Override
    public Enrollment newEnrollment(int enrollmentId, Student student, Course course, int period) {
        return enrollmentDAO.newEnrollment(enrollmentId, student, course, period);
    }
}
