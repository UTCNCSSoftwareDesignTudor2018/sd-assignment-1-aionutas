package tests.models;

import entity.Teacher;

public class TeacherTestBuilder {
    public static Teacher createInitialTeacher(){
        return new Teacher("Rodica Potolea",1, "UTCN", 1221,2321, "rpotolea",  "rpotolea");
    }
    public static Teacher createUpdatedTeacher(){
        return new Teacher("Rodica Potolea",1, "UTCN", 1222,2321, "rpotolea",  "rpotolea");
    }

    public static Teacher addNewTeacher(){
        return new Teacher("Maria Ioana",4, "BABES", 231,321, "mioana",  "mioana");
    }
}
