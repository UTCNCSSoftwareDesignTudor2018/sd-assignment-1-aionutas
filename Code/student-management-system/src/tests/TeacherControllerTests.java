package tests;

import business.TeacherBLL;
import entity.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static tests.models.TeacherTestBuilder.addNewTeacher;
import static tests.models.TeacherTestBuilder.createInitialTeacher;
import static tests.models.TeacherTestBuilder.createUpdatedTeacher;

@RunWith(MockitoJUnitRunner.class)
public class TeacherControllerTests {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    TeacherBLL teacherBLL;


    @Test
    public void shouldGetStudentById() {
        Teacher initialTeacher = createInitialTeacher();
        when(teacherBLL.findTeacherById(1)).thenReturn(initialTeacher);
        assertTrue(teacherBLL.findTeacherById(1).equals(initialTeacher));
    }


    @Test
    public void shouldUpdate() {
        Teacher initialTeacher = createInitialTeacher();
        Teacher updatedTeacher = createUpdatedTeacher();
        teacherBLL.update(initialTeacher.getId(), updatedTeacher);
        when(teacherBLL.findTeacherById(1)).thenReturn(initialTeacher);
        teacherBLL.update(initialTeacher.getId(), updatedTeacher);
        when(teacherBLL.findTeacherById(1)).thenReturn(updatedTeacher);
        assertTrue(teacherBLL.findTeacherById(1).equals(updatedTeacher));
    }
}


