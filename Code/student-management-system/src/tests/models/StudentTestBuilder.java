package tests.models;

import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTestBuilder {
    public static Student createStudent(){
        return new Student("Andreea Ionutas Raluca", 1, "Dumbrava", 23, 35273);
    }
    public static List<Student> createListStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Andreea Ionutas Raluca", 1, "Dumbrava", 23,"aionutas", "aionutas", 35273));
        studentList.add(new Student("Popescu", 3, "Alba Iulia", 987654321, "popesm","parola",1234567890));
        studentList.add(new Student("Magdalena Capros", 2, "Moldova", 35621, "popesm","35621",35621));
        return studentList;
    }
    public static Student createUpdatedStudent(){
        return new Student("Andreea Ionutas Raluca", 1, "Dumbrava", 24, "aionutas", "aionutas",35273);
    }
    public static Student createInitialStudent(){
        return new Student("Andreea Ionutas Raluca", 1, "Dumbrava", 23, "aionutas", "aionutas",35273);
    }

    public static Student addNewStudent(){
        return new Student("Maria", 2, "Cluj", 23, "maria", "maria",35273);
    }

}