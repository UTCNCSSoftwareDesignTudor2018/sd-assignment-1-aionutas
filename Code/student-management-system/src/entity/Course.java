package entity;

public class Course {
    private int courseId;
    private String name;
    private String teacherName;
    private String examLevel;

    public Course(int courseId, String name, String teacherName, String examLevel) {
        this.courseId = courseId;
        this.name = name;
        this.teacherName = teacherName;
        this.examLevel = examLevel;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getExamLevel() {
        return examLevel;
    }

    public void setExamLevel(String examLevel) {
        this.examLevel = examLevel;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (teacherName != null ? !teacherName.equals(course.teacherName) : course.teacherName != null) return false;
        return examLevel != null ? examLevel.equals(course.examLevel) : course.examLevel == null;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (examLevel != null ? examLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", examLevel='" + examLevel + '\'' +
                '}';
    }
}
