package tests;

import business.TeacherBLL;
import entity.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static tests.models.TeacherTestBuilder.addNewTeacher;
import static tests.models.TeacherTestBuilder.createInitialTeacher;
import static tests.models.TeacherTestBuilder.createUpdatedTeacher;

public class TeacherControllerTests {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    TeacherBLL teacherBLL;

    @Test
    public void shouldGetStudentById(){
        Teacher initialTeacher = createInitialTeacher();
        when(teacherBLL.findTeacherById(1)).thenReturn(initialTeacher);
    }


    @Test
    public void shouldUpdate(){
        Teacher initialTeacher = createInitialTeacher();
        Teacher updatedTeacher = createUpdatedTeacher();
        teacherBLL.update(initialTeacher.getId(), updatedTeacher);
        when(teacherBLL.findTeacherById(1)).thenReturn(initialTeacher);
        teacherBLL.update(initialTeacher.getId(), updatedTeacher);
        when(teacherBLL.findTeacherById(1)).thenReturn(updatedTeacher);

    }

    @Test
    public void shouldAddTeacher(){
        Teacher insertTeacher = addNewTeacher();
        teacherBLL.newTeacher(insertTeacher.getName(), insertTeacher.getId(), insertTeacher.getAddress(), insertTeacher.getIdentityCardNumber(), insertTeacher.getPersonalNumericalCode(), insertTeacher.getUsername(), insertTeacher.getPassword());
        when(teacherBLL.findTeacherById(4)).thenReturn(insertTeacher);
    }
}
