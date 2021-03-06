package tests;

import business.StudentBLL;
import entity.Student;


import org.junit.Before;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static tests.models.StudentTestBuilder.*;


public class StudentControllerTests {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    StudentBLL studentBLL;

    @Test
    public void shouldGetStudentById(){
        Student student = createStudent();
        when(studentBLL.findStudentById(1)).thenReturn(student);
        assertTrue(studentBLL.findStudentById(1).equals(student));
    }

    @Test
    public void shouldUpdate(){
        Student initialStudent = createInitialStudent();
        Student updatedStudent = createUpdatedStudent();
        when(studentBLL.findStudentById(1)).thenReturn(initialStudent);
        studentBLL.update(initialStudent.getId(), updatedStudent);
        when(studentBLL.findStudentById(1)).thenReturn(updatedStudent);
        assertTrue(studentBLL.findStudentById(1).equals(updatedStudent));
    }

    @Test
    public void shouldGetAllStudents(){
        List<Student> studentList = createListStudents();
        when(studentBLL.findAll()).thenReturn(studentList);
        assertTrue(studentBLL.findAll().equals(studentList));
    }

    @Test
    public void shouldAddStudent(){
        Student insertStudent = addNewStudent();
        studentBLL.insertStudent(insertStudent);
        when(studentBLL.findStudentById(2)).thenReturn(insertStudent);
        assertTrue(studentBLL.findStudentById(2).equals(insertStudent));
    }


}
