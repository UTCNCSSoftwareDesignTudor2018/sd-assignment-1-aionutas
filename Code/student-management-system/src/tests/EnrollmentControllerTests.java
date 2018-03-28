package tests;

import business.EnrollmentBLL;
import entity.Enrollment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import static tests.models.EnrollmentTestBuilder.createEnrollment;

public class EnrollmentControllerTests {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    EnrollmentBLL enrollmentBLL;

    @Test
    public void shouldEnroll(){
        Enrollment newEnrollment = createEnrollment();
        enrollmentBLL.enroll(newEnrollment);
        when(enrollmentBLL.findEnrollmentById(1)).thenReturn(newEnrollment);
    }

    @Test
    public void shouldReturnEnrollment(){
        Enrollment enrollment = createEnrollment();
        when(enrollmentBLL.findEnrollmentById(1)).thenReturn(enrollment);
    }
}
