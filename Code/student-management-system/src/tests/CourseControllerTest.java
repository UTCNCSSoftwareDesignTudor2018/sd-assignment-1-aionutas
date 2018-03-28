package tests;

import business.CourseBLL;
import entity.Course;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static tests.models.CourseTestBuilder.createCourse;

public class CourseControllerTest {
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    CourseBLL courseBLL;

    @Test
    public void shouldGetCourseById(){
        Course course = createCourse();
        when(courseBLL.findById(1)).thenReturn(course);
    }
}
