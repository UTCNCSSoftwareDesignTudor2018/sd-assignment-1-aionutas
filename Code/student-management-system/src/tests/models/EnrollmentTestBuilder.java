package tests.models;

import entity.Enrollment;

import static tests.models.CourseTestBuilder.createCourse;
import static tests.models.StudentTestBuilder.createStudent;


public class EnrollmentTestBuilder {
    public static Enrollment createEnrollment() {
        return new Enrollment(3, createStudent(), createCourse(), 3);
    }
}
