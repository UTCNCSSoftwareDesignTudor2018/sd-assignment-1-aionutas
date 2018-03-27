package business.interfaces;

import entity.Course;
import entity.Enrollment;
import entity.Student;

public interface EnrollmentBLLInterface {
    public void enroll(Enrollment enrollment);
    public Enrollment newEnrollment(int enrollmentId, Student student, Course course, int period);
}
