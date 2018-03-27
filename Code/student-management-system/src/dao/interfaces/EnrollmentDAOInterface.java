package dao.interfaces;

import entity.Course;
import entity.Enrollment;
import entity.Student;

public interface EnrollmentDAOInterface {
    public void enroll(Enrollment enrollment);
    public Enrollment newEnrollment(int enrollmentId, Student student, Course course, int period);
}
