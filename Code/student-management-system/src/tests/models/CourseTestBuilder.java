package tests.models;


import entity.Course;

public class CourseTestBuilder {
    public static Course createCourse(){
        return new Course(1, "Logic Design", "Octavian Cret", "hard");
    }
}
